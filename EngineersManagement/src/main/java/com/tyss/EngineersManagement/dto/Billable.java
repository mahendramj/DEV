package com.tyss.EngineersManagement.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
public class Billable {
	@Id
	@GeneratedValue
	@Column
	private int employeeId;
	@Column
	private Date deployementDate;
	@Column
	private Date contractEndDate;
	@Column
	private double rateCardPerMonth;
	@Column
	private String stack;
	@Column
	private String yoe;
	@JoinColumn(name = "clientId")
	@ManyToOne(cascade = CascadeType.ALL)
	private ClientsInfo info;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDeployementDate() {
		return deployementDate;
	}

	public void setDeployementDate(Date deployementDate) {
		this.deployementDate = deployementDate;
	}

	public Date getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public double getRateCardPerMonth() {
		return rateCardPerMonth;
	}

	public void setRateCardPerMonth(double rateCardPerMonth) {
		this.rateCardPerMonth = rateCardPerMonth;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public String getYoe() {
		return yoe;
	}

	public void setYoe(String yoe) {
		this.yoe = yoe;
	}

	public ClientsInfo getInfo() {
		return info;
	}

	public void setInfo(ClientsInfo info) {
		this.info = info;
	}

}
