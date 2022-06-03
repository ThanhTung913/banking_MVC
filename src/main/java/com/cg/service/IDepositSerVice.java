package com.cg.service;

import com.cg.model.Customer;
import com.cg.model.Deposit;

import java.math.BigDecimal;
import java.util.List;

public interface IDepositSerVice {

    List<Customer> selectAll();

    Customer selectCustomer(int id);

    boolean create(int id, BigDecimal amount);


}
