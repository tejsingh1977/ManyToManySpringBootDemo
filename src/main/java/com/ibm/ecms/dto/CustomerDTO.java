package com.ibm.ecms.dto;

import java.time.LocalDate;
import java.util.Set;

public class CustomerDTO {
	
	private Integer customerId;
	private String emailId;
	private String name;
	private LocalDate dateOfBirth;
	private Set<ServicesDTO> bankServices;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Set<ServicesDTO> getBankServices() {
		return bankServices;
	}
	public void setBankServices(Set<ServicesDTO> bankServices) {
		this.bankServices = bankServices;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", bankServices=" + bankServices + "]";
	}
	
}
