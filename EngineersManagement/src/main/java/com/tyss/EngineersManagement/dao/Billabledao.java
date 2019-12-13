package com.tyss.EngineersManagement.dao;

import java.util.List;

import com.tyss.EngineersManagement.dto.Billable;

public interface Billabledao {
	public boolean insert(Billable bill);
	public boolean delete(int bid);
	public boolean update(Billable bill);
	public List<Billable> getAllBillable();
}
