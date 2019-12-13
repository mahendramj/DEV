package com.tyss.EngineersManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.EngineersManagement.dao.Billabledao;
import com.tyss.EngineersManagement.dto.Billable;

@Service
public class BillableServiceImpl implements BillableService{
	@Autowired
	private Billabledao dao;
	
	@Override
	public boolean insert(Billable bill) {
		return dao.insert(bill);
	}

	
	@Override
	public boolean update(Billable empBill) {
		return dao.update(empBill);
	}

	@Override
	public List<Billable> getAllBillable() {
		return dao.getAllBillable();
	}


	@Override
	public boolean delete(int bId) {
		return dao.delete(bId);
	}

}
