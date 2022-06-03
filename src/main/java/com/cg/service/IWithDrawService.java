package com.cg.service;

import com.cg.model.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface IWithDrawService {
    List<Customer> selectAll();

    Customer selectCustomer(int id);

    boolean withdraw(int id, BigDecimal amount,String message);
}
