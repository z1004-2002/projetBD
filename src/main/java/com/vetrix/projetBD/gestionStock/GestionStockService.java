package com.vetrix.projetBD.gestionStock;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestionStockService {

    private final GestionStockRepo stockRepository;

    public GestionStockService(GestionStockRepo stockRepository) {
        this.stockRepository = stockRepository;
    }

    public GestionStockDto stock(int id){
        GestionStockDto record = new GestionStockDto();
        GestionStock stock = stockRepository.findById(id).get();

        record.setIdStock(stock.getIdStock());
        record.setDateStock(stock.getDateStock());
        record.setQte(stock.getQte());
        record.setOperation(stock.getOperation());
        record.setIdGest(stock.getIdGest());
        record.setCodePro(stock.getCodePro());

        return record;
    }

    public List<GestionStockDto> getStock(){
        List<GestionStockDto> stock = new ArrayList<>();
        for (GestionStock record : stockRepository.findAll()){
            stock.add(stock(record.getIdStock()));
        }
        return stock;
    }
}
