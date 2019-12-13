package com.tyss.EngineersManagement.service;

import java.util.List;

import com.tyss.EngineersManagement.dto.ClientsInfo;

public interface ClientsInfoService {
	public boolean insert(ClientsInfo clientinfo);
	public boolean delete(int bid);
	public boolean update(ClientsInfo clientinfo);
	public List<ClientsInfo> getAllClients();
}
