package com.tyss.EngineersManagement.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tyss.EngineersManagement.dto.Billable;

@Repository
public class BillableImpl implements Billabledao{

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public boolean insert(Billable bill) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bill);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int bId) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Billable bill1 = manager.find(Billable.class, bId);
		if (bill1 == null) {
			return false;
		}
		transaction.begin();
		manager.remove(bill1);
		transaction.commit();
		return true;
	}

	@Override
	public boolean update(Billable empBill) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Billable empBill1=manager.find(Billable.class,empBill.getEmployeeId());
		if(empBill1==null) {
			return false;
		}
		transaction.begin();
		empBill1.setContractEndDate(empBill.getContractEndDate());
		empBill1.setDeployementDate(empBill.getDeployementDate());
		empBill1.setRateCardPerMonth(empBill.getRateCardPerMonth());
		empBill1.setStack(empBill.getStack());
		empBill1.setYoe(empBill.getYoe());
		transaction.commit();
		return true;
	}

	@Override
	public List<Billable> getAllBillable() {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		String get = "from Billable";
		Query query = (Query) manager.createQuery(get);
		List<Billable> list=query.getResultList();
		if (list == null) {
			return null;
		}
		return list;
	}

}