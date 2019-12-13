package com.tyss.EngineersManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.tyss.EngineersManagement.dto.ClientContactInfo;

@Repository
public class ClientContactInfoDaoImpl implements ClientContactInfoDao {
	@PersistenceUnit
	private EntityManagerFactory emf;
		@Override
		public boolean addClientCont(ClientContactInfo cInfo) {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			try {
				transaction.begin();
				manager.persist(cInfo);
				transaction.commit();
				return true;
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
				return false;
			}
		}

		@Override
		public boolean updateClientCont(ClientContactInfo cInfo) {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			ClientContactInfo cliInfo = manager.find(ClientContactInfo.class, cInfo);
			if (cliInfo == null) {
				return false;
			}
			transaction.begin();
			cliInfo.setContactPersonCatageory(cInfo.getContactPersonCatageory());
			cliInfo.setContactPersonEmail(cInfo.getContactPersonEmail());
			cliInfo.setContactPersonName(cInfo.getContactPersonName());
			cliInfo.setContactPersonNumber(cInfo.getContactPersonNumber());
			transaction.commit();
			return true;
		}

		@Override
		public boolean deleteClientCont(int cInfoId) {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			ClientContactInfo cInfo = manager.find(ClientContactInfo.class, cInfoId);
			if (cInfo == null) {
				return false;
			}
			transaction.begin();
			manager.remove(cInfo);
			transaction.commit();
			return true;
		}

		@Override
		public List<ClientContactInfo> getClientCont() {
			EntityManager manager = emf.createEntityManager();
			String get = "from ClientContactInfo";
			Query query = (Query) manager.createQuery(get);
			List<ClientContactInfo> list = query.getResultList();
			if (list == null) {
				return null;
			}
			return list;
		}
	}
