package com.ibm.ecms.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ibm.ecms.dto.CustomerDTO;
import com.ibm.ecms.dto.ServicesDTO;
import com.ibm.ecms.entity.Customer;
import com.ibm.ecms.entity.Services;
import com.ibm.ecms.exception.InfyBankException;
import com.ibm.ecms.repository.CustomerRepository;
import com.ibm.ecms.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "bankService")
@Transactional
public class BankServiceImpl implements BankService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ServicesRepository servicesRepository;
	
	@Override
	public Integer addCustomerAndService(CustomerDTO customerDTO) throws InfyBankException {
		Integer customerId = null;
		Set<ServicesDTO> bankServicesDTO = customerDTO.getBankServices();
		Customer customer = new Customer();
		
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customer.setEmailId(customerDTO.getEmailId());
		customer.setName(customerDTO.getName());
		Set<Services> bankServices = null;
		if (bankServicesDTO != null && !bankServicesDTO.isEmpty()) {
			bankServices = new LinkedHashSet<>();
			for (ServicesDTO servicesDTO : bankServicesDTO) {
				Services service = new Services();
				service.setServiceId(servicesDTO.getServiceId());
				service.setServiceName(servicesDTO.getServiceName());
				service.setServiceCost(servicesDTO.getServiceCost());
				bankServices.add(service);
			}
			customer.setBankServices(bankServices);
		}
		
		customerRepository.save(customer);
		customerId = customer.getCustomerId();
		return customerId;
	}
	
	@Override
	public void addExistingServiceToExistingCustomer(Integer customerId,List<Integer> serviceIds) throws InfyBankException {
		
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_UNAVAILABLE"));
		
		for(Integer serviceId : serviceIds) {
			Optional<Services> optional1 = servicesRepository.findById(serviceId);
			Services service = optional1.orElseThrow(() -> new InfyBankException("Service.SERVICE_UNAVAILABLE"));
			if(!customer.getBankServices().contains(service)) {
				customer.getBankServices().add(service);
			}
		}
	}
	
	@Override
	public void deallocateServiceForExistingCustomer(Integer customerId,List<Integer> serviceIds) throws InfyBankException {
		
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_UNAVAILABLE"));
		Set<Services> bankServices = customer.getBankServices();
		for(Integer serviceId:serviceIds) {
			Optional<Services> optional1 = servicesRepository.findById(serviceId);
			if(optional1.isPresent()) {
				Services service = optional1.get();
				bankServices.remove(service);
			}
		}
	}	
}
