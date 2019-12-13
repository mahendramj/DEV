package com.tyss.EngineersManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.EngineersManagement.dao.ClientsInfoDao;
import com.tyss.EngineersManagement.dto.ClientsInfo;
@Service
public class ClientsInfoServiceImpl implements ClientsInfoService{
	@Autowired
	private	ClientsInfoDao dao;
	@Override
	public boolean insert(ClientsInfo clientinfo) {
	
		return dao.insert(clientinfo);
	}

	@Override
	public boolean delete(int clientId) {
		
		return dao.delete(clientId);
	}

	@Override
	public boolean update(ClientsInfo clientinfo) {
		// TODO Auto-generated method stub
		return dao.update(clientinfo);
	}

	@Override
	public List<ClientsInfo> getAllClients() {
		// TODO Auto-generated method stub
		return dao.getAllClients();
	}

}
