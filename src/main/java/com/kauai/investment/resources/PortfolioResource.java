package com.kauai.investment.resources;

import com.kauai.investment.entities.Portfolio;
import com.kauai.investment.entities.Transaction;
import com.kauai.investment.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.List;

@RestController
@RequestMapping(value = "/portfolio")
public class PortfolioResource {

    @Autowired
    private PortfolioService service;

    @GetMapping
    public ResponseEntity<List<Portfolio>> findAll(){
        List<Portfolio> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Portfolio> findById(@PathVariable Long id){
        Portfolio obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public Portfolio save(@RequestBody Portfolio portfolio){
        return service.save(portfolio);
    }

    @PutMapping(value = "/{id}")
    public Portfolio update(@PathVariable Long id, @RequestBody Portfolio portfolioUpdate) throws Exception {
        return service.update(id, portfolioUpdate);
    }

    @PutMapping(value = "/{id}/transaction")
    public Transaction addNewTransaction(@PathVariable Long id, @RequestBody Transaction transaction){
        return service.addNewTransaction(id, transaction);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
