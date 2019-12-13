package com.tyss.EngineersManagement.dto;

import java.util.List;

import lombok.Data;

public class ClientsInfoStatusCode {
	private int statusCode;
	private String message;
	private String description;
	private List<ClientsInfo> clients;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ClientsInfo> getClients() {
		return clients;
	}
	public void setClients(List<ClientsInfo> clients) {
		this.clients = clients;
	}


}
