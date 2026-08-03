package com.kauai.investment.service;

import com.kauai.investment.entities.Asset;
import com.kauai.investment.repositories.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    @Autowired
    private AssetRepository repository;

    public List<Asset> findAll(){
        return repository.findAll();
    }

    public Asset findById(Long id){
        Optional<Asset> obj = repository.findById(id);
        return obj.get();
    }

    public Asset save(Asset asset){
        return repository.save(asset);
    }

    public Asset update(Long id, Asset assetUpdate) throws Exception {
        Asset obj = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        obj.setCompany_name(assetUpdate.getCompany_name());
        obj.setTicker(assetUpdate.getTicker());
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}

