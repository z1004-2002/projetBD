package com.vetrix.projetBD.photo;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
@Slf4j
@NoArgsConstructor
public class PhotoService {

	private PhotoRepository photoRepository;
	private Path fileStorageLocationProduct;

	@Autowired
	public PhotoService(
			PhotoRepository photoRepository,
			PhotoStorageProperties photoStorageProperties
			) {
		super();
		this.photoRepository = photoRepository;

		this.fileStorageLocationProduct = Paths
				.get(System.getProperty("user.dir") + photoStorageProperties.getProductDir()).toAbsolutePath()
				.normalize();
		log.info("========>Image Path = {}<========", fileStorageLocationProduct);

		try {
			Files.createDirectories(this.fileStorageLocationProduct);
		} catch (Exception ex) {
			throw new RuntimeException("Could not create the directory to upload.");
		}
	}

	public PhotoDto getImageById(Long imageId) {
		log.info("Service: Fetching Image {}", imageId);
		return photoRepository.findById(imageId).get();
	}

	public List<PhotoDto> findByCod(int code){
		return photoRepository.findByCod(code);
	}
	public PhotoDto submitImage(MultipartFile file, int codePro) {

		//GENERATION OF VARCHAR

		String completeName = "abe";
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcdefghijklmnopqrstuvxyz";

		StringBuilder s = new StringBuilder(50);
		for (int i = 0; i < 50; i++) {
			int index = (int)(str.length() * Math.random());
			s.append(str.charAt(index));
		}
		completeName = String.valueOf(s);

		//END OF GENERATION

		log.info("Image Name = {}", file.getOriginalFilename());
		String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
		try {
			Path targetLocation = this.fileStorageLocationProduct.resolve(completeName+fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path(System.getProperty("user.dir") + "/src/main/resources/static/image/").path(completeName + fileName)
					.toUriString();
			return photoRepository.save(
					new PhotoDto(null, completeName+fileName, codePro));
		} catch (IOException e) {
			throw new RuntimeException("Could not store file " + completeName+fileName + ". Please try again!", e);
		}
	}

	public Resource loadProfileImage(String fileName) {
		log.info("Load File = {} Successfully", fileName);
		try {
			Path filePath = this.fileStorageLocationProduct.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new RuntimeException("Le fichier: " + fileName + " est introuvable");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Le fichier: " + fileName + " est introuvable");
		}
	}


	public void deleteById(Long id){
		photoRepository.deleteById(id);
	}
}
