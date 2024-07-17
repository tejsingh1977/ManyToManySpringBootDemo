package com.ibm.ecms.repository;

import com.ibm.ecms.entity.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}