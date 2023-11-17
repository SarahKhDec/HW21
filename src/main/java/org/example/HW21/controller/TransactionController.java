package org.example.HW21.controller;

import org.example.HW21.dto.search.APIResponse;
import org.example.HW21.entity.Transaction;
import org.example.HW21.mappers.TransactionMapper;
import org.example.HW21.search.SearchCriteria;
import org.example.HW21.search.SearchDto;
import org.example.HW21.search.TransactionSpecificationBuilder;
import org.example.HW21.service.impl.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    private final TransactionServiceImpl transactionService;
    private final TransactionMapper transactionMapper;

    @PostMapping("/search")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<APIResponse> findAll(@RequestBody SearchDto searchDto) {
        APIResponse apiResponse = new APIResponse();
        TransactionSpecificationBuilder builder = new TransactionSpecificationBuilder();
        List<SearchCriteria> criteriaList = searchDto.getSearchCriteriaList();
        if (criteriaList != null) {
            criteriaList.forEach(x -> {
                x.setDataOption(searchDto
                        .getDataOption());
                builder.with(x);
            });
        }

        List<Transaction> transactionList = transactionService.search(builder.build());
        apiResponse.setData(transactionMapper.transactionListToDtoList(transactionList));
        apiResponse.setResponseCode(HttpStatus.OK);
        apiResponse.setMessage("Successfully retrieved customer record");

        return new ResponseEntity<>(apiResponse, apiResponse.getResponseCode());
    }
}
