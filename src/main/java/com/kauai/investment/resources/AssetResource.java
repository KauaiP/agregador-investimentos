package com.kauai.investment.resources;

import com.kauai.investment.entities.Asset;
import com.kauai.investment.entities.User;
import com.kauai.investment.service.AssetService;
import com.kauai.investment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/asset")
public class AssetResource {

    @Autowired
    private AssetService service;

    @GetMapping
    public ResponseEntity<List<Asset>> findAll(){
        List<Asset> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Asset> findById(@PathVariable Long id){
        Asset obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public Asset save(@RequestBody Asset asset){
        return service.save(asset);
    }

    @PutMapping(value = "/{id}")
    public Asset update(@PathVariable Long id, @RequestBody Asset assetUpdate) throws Exception {
        return service.update(id, assetUpdate);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
