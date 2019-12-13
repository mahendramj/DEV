package com.tyss.EngineersManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.EngineersManagement.dao.ClientContactInfoDao;
import com.tyss.EngineersManagement.dto.ClientContactInfo;
@Service
public class ClientContactInfoServiceImpl implements ClientContactInfoService{

	@Autowired
	private ClientContactInfoDao dao;
	@Override
	public boolean addClientCont(ClientContactInfo cInfo) {
		
		return dao.addClientCont(cInfo);
	}

	@Override
	public boolean updateClientCont(ClientContactInfo cInfo) {
	
		return dao.updateClientCont(cInfo);
	}

	@Override
	public boolean deleteClientCont(int cInfoId) {
	
		return dao.deleteClientCont(cInfoId);
	}

	@Override
	public List<ClientContactInfo> getClientCont() {
		
		return dao.getClientCont();
	}

}
