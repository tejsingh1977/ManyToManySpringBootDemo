package com.ibm.ecms.dto;

public class ServicesDTO {
	
	private Integer serviceId;
	private String serviceName;
	private Integer serviceCost;
	
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(Integer serviceCost) {
		this.serviceCost = serviceCost;
	}
	
	@Override
	public String toString() {
		return "ServicesDTO [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceCost=" + serviceCost
				+ "]";
	}
	
}
