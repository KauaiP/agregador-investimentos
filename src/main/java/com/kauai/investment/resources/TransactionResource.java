package com.kauai.investment.resources;

import com.kauai.investment.entities.Asset;
import com.kauai.investment.entities.Transaction;
import com.kauai.investment.service.AssetService;
import com.kauai.investment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionResource {

    @Autowired
    private TransactionService service;

    @GetMapping
    public ResponseEntity<List<Transaction>> findAll(){
        List<Transaction> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id){
        Transaction obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction transactionUpdate) throws Exception {
        return service.update(id, transactionUpdate);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
