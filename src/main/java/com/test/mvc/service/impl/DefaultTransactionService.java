package com.test.mvc.service.impl;

import com.test.mvc.domain.Transaction;
import com.test.mvc.mapper.TransactionMapper;
import com.test.mvc.service.ITransactionService;
import com.test.mvc.domain.Transaction;
import com.test.mvc.mapper.TransactionMapper;
import com.test.mvc.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/26.
 */
@Service
public class DefaultTransactionService implements ITransactionService {
    @Autowired
     private TransactionMapper transactionMapper;

    @Override
    public void addTransaction(Transaction t) {
        transactionMapper.addTransaction(t);
    }
}
