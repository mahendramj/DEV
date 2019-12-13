package com.tyss.EngineersManagement.service;

import java.util.List;

import com.tyss.EngineersManagement.dto.Billable;

public interface BillableService {

	public boolean insert(Billable bill);
	public boolean delete(int bId);
	public boolean update(Billable bill);
	public List<Billable> getAllBillable();
	
	
	
}