package com.tyss.EngineersManagement.dao;

import java.util.List;


import com.tyss.EngineersManagement.dto.ClientsInfo;

public interface ClientsInfoDao {
	public boolean insert(ClientsInfo clientinfo);
	public boolean delete(int clientId);
	public boolean update(ClientsInfo clientinfo);
	public List<ClientsInfo> getAllClients();
}
