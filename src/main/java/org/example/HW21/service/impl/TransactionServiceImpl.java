package org.example.HW21.service.impl;

import org.example.HW21.entity.Transaction;
import org.example.HW21.repository.TransactionRepository;
import org.example.HW21.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public void create(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> search(Specification<Transaction> spec) {
        return transactionRepository.findAll(spec);
    }
}
