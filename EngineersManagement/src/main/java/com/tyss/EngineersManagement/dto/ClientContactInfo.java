package com.tyss.EngineersManagement.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ClientContactInfo {
	@Id
	@Column
	private int clientInfoId;
	@Column
	private String contactPersonName;
	@Column
	private String contactPersonCatageory;
	@Column
	private double contactPersonNumber;
	@Column
	private String contactPersonEmail;
	@JoinColumn(name = "clientId")
	@ManyToOne(cascade = CascadeType.ALL)
	private ClientsInfo info;

	public int getClientInfoId() {
		return clientInfoId;
	}

	public void setClientInfoId(int clientInfoId) {
		this.clientInfoId = clientInfoId;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonCatageory() {
		return contactPersonCatageory;
	}

	public void setContactPersonCatageory(String contactPersonCatageory) {
		this.contactPersonCatageory = contactPersonCatageory;
	}

	public double getContactPersonNumber() {
		return contactPersonNumber;
	}

	public void setContactPersonNumber(double contactPersonNumber) {
		this.contactPersonNumber = contactPersonNumber;
	}

	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public ClientsInfo getInfo() {
		return info;
	}

	public void setInfo(ClientsInfo info) {
		this.info = info;
	}
}
