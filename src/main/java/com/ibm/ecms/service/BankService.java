package com.ibm.ecms.service;
import com.ibm.ecms.dto.CustomerDTO;
import com.ibm.ecms.exception.InfyBankException;

import java.util.List;



public interface BankService {
	public Integer addCustomerAndService(CustomerDTO customerDTO) throws InfyBankException;
	public void addExistingServiceToExistingCustomer(Integer customerId,List<Integer> serviceIds) throws InfyBankException;
	public void deallocateServiceForExistingCustomer(Integer customerId,List<Integer> serviceIds) throws InfyBankException;		
}