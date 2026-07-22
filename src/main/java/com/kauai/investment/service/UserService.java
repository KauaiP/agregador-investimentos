package com.kauai.investment.service;

import com.kauai.investment.entities.User;
import com.kauai.investment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User save(User user){
        return repository.save(user);
    }

    public User update(Long id, User userUpdate) throws Exception {
        User obj = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        obj.setEmail(userUpdate.getEmail());
        obj.setName(userUpdate.getName());
        obj.setPassword(userUpdate.getPassword());
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
