package com.cg.service;

import com.cg.model.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface IDepositSerVice {

    List<Customer> selectAll();

    Customer selectCustomer(int id);

    boolean deposit(int id, BigDecimal amount);


}
