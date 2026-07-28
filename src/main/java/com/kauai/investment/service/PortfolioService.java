package com.kauai.investment.service;

import com.kauai.investment.entities.Asset;
import com.kauai.investment.entities.Portfolio;
import com.kauai.investment.entities.Transaction;
import com.kauai.investment.entities.User;
import com.kauai.investment.repositories.PortfolioRepository;
import com.kauai.investment.repositories.TransactionRepository;
import com.kauai.investment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository repository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Portfolio> findAll(){
        return repository.findAll();
    }

    public Portfolio findById(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Carteira não encontrada"));
    }

    public Portfolio save(Portfolio portfolio) {
        Long userId = portfolio.getUser().getId();
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        portfolio.setUser(user);

        return repository.save(portfolio);
    }

    public Portfolio update(Long id, Portfolio new_portfolio){
        Portfolio obj = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Carteira não encontrada"));
        obj.setName(new_portfolio.getName());
        obj.setUser(new_portfolio.getUser());
        // talvez necessário implementar uma maneira de atualizar a lista toda em um update
        return save(obj);
    }

    public void delete(Long id){
        Portfolio obj = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Carteira não encontrada"));
        repository.delete(obj);
    }

    public Transaction addNewTransaction(Long id, Transaction transaction) {
        Portfolio portfolio = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Carteira não encontrada"));
        portfolio.addTransaction(transaction);
        return transactionRepository.save(transaction);
    }
}
