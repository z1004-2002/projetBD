package com.vetrix.projetBD.facture;

import com.vetrix.projetBD.lineFacture.LineFactRepository;
import com.vetrix.projetBD.lineFacture.LineFacture;
import com.vetrix.projetBD.lineFacture.ProdFac;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FactureService {
    private final FactureRepository repository;
    private final LineFactRepository lineFactRepository;

    public FactureService(FactureRepository repository, LineFactRepository lineFactRepository) {
        this.repository = repository;
        this.lineFactRepository = lineFactRepository;
    }
    public Facture addFac(FactureDto factureDto) {
        Facture facture = new Facture(
                factureDto.getIdFac(),
                factureDto.getDateFac(),
                factureDto.getRemise(),
                factureDto.getMontant(),
                factureDto.getTel(),
                factureDto.getTypeFac(),
                factureDto.getIdCaissiere(),
                factureDto.getCapital(),
                factureDto.getTva()
        );
        Facture fac = repository.save(facture);
        for (ProdFac prodFac: factureDto.getProduits()){
            lineFactRepository.save(
                    new LineFacture(
                            prodFac.getCodePro(),
                            fac.getIdFac(),
                            prodFac.getPrix(),
                            prodFac.getQte()
                    )
            );
        }

        return fac;
    }
    public List<FactureDto> getFac() {
        List<FactureDto> factureDtos = new ArrayList<>();
        List<Facture> factures = repository.findAll();
        for (Facture fact : factures){
            factureDtos.add(getFac(fact.getIdFac()));
        }

        return factureDtos;
    }
    public FactureDto getFac(int id) {
        Facture facture = repository.findById(id).get();
        FactureDto factureDto = new FactureDto(
                facture.getIdFac(),
                facture.getDateFac(),
                facture.getRemise(),
                facture.getMontant(),
                facture.getTel(),
                facture.getTypeFac(),
                facture.getIdCaissiere(),
                facture.getCapital(),
                facture.getTva()
        );

        List<ProdFac> prodFacs = new ArrayList<>();
        List<LineFacture> lineFactures = lineFactRepository.getLineByFacture(id);
        for (LineFacture lineFacture:lineFactures){
            prodFacs.add(
                    new ProdFac(
                            lineFacture.getCodePro(),
                            lineFacture.getIdFac(),
                            lineFacture.getPrix(),
                            lineFacture.getQte()
                    )
            );
        }
        factureDto.setProduits(prodFacs);
        return factureDto;
    }
    public Facture updateFac(int id, Facture facture) {
        if(!repository.existsById(id))
            throw new IllegalStateException("Facture not found");
        repository.findById(id).map(f -> {
            f.setCapital(facture.getCapital());
            f.setDateFac(facture.getDateFac());
            f.setRemise(facture.getRemise());
            f.setTel(facture.getTel());
            f.setMontant(facture.getMontant());
            f.setIdCaissiere(facture.getIdCaissiere());
            f.setTva(facture.getTva());
            f.setTypeFac(facture.getTypeFac());
            return repository.save(f);
        });
        return facture;
    }

    public void deleteFac(int id){
        if(!repository.existsById(id))
            throw new IllegalStateException("Facture not found");
        repository.deleteById(id);
    }
}
