package org.example.HW21.mappers;

import org.example.HW21.dto.transaction.TransactionDto;
import org.example.HW21.entity.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    List<TransactionDto> transactionListToDtoList(List<Transaction> transactionList);
}
