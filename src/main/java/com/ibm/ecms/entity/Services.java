package com.ibm.ecms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Services {
	
	@Id
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceCost == null) ? 0 : serviceCost.hashCode());
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
		result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Services other = (Services) obj;
		if (serviceCost == null) {
			if (other.serviceCost != null)
				return false;
		} else if (!serviceCost.equals(other.serviceCost))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		return true;
	}

	
}