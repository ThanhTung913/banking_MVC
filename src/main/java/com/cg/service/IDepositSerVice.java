package com.cg.service;

import com.cg.model.Customer;
import com.cg.model.Deposit;

import java.util.List;

public interface IDepositSerVice {

    List<Customer> selectAll();

    Customer selectCustomer(int id);

    int create(Deposit deposit);


}
