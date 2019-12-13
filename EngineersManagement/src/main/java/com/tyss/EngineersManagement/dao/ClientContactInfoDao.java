package com.tyss.EngineersManagement.dao;

import java.util.List;

import com.tyss.EngineersManagement.dto.ClientContactInfo;

public interface ClientContactInfoDao {
	

		public boolean addClientCont(ClientContactInfo cInfo);
		public boolean updateClientCont(ClientContactInfo cInfo);
		public boolean deleteClientCont(int cInfoId);
		public List<ClientContactInfo> getClientCont();
	}

