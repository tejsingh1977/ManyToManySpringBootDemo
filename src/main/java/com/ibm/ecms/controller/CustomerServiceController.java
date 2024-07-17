package com.ibm.ecms.controller;

import com.ibm.ecms.dto.CustomerDTO;
import com.ibm.ecms.exception.InfyBankException;
import com.ibm.ecms.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/indusindbank")
public class CustomerServiceController {

    @Autowired
    BankService bankService;

    @Autowired
    Environment environment;

    @PostMapping(value = "/customerservice")
    public ResponseEntity<String> addCustomerAndService(@RequestBody CustomerDTO customerDTO){
        try {
            Integer  customerId = bankService.addCustomerAndService(customerDTO);
            String successMessage = environment.getProperty("UserInterface.NEW_CUSTOMER_SUCCESS" + customerId);
            return  new ResponseEntity<>(successMessage, HttpStatus.CREATED);
        } catch (InfyBankException e) {
            throw new RuntimeException(e);
        }
    }
}
