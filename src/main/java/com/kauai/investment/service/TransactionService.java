package com.kauai.investment.service;

import com.kauai.investment.entities.Asset;
import com.kauai.investment.entities.Transaction;
import com.kauai.investment.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<Transaction> findAll(){
        return repository.findAll();
    }

    public Transaction findById(Long id){
        Optional<Transaction> obj = repository.findById(id);
        return obj.get();
    }

    public Transaction update(Long id, Transaction transactionUpdate) throws Exception {
        Transaction obj = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        obj.setAsset(transactionUpdate.getAsset());
        obj.setPortfolio(transactionUpdate.getPortfolio());
        obj.setQuantity(transactionUpdate.getQuantity());
        obj.setPurChasePrice(transactionUpdate.getPurChasePrice());
        obj.setPurChaseDate(transactionUpdate.getPurChaseDate());
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}

