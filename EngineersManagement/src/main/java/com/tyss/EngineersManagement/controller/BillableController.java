package com.tyss.EngineersManagement.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.EngineersManagement.dto.Billable;
import com.tyss.EngineersManagement.dto.BillableResponse;
import com.tyss.EngineersManagement.service.BillableService;

@RestController
@RequestMapping("/billable")
public class BillableController {
	@Autowired
	private BillableService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
	CustomDateEditor editor=new CustomDateEditor(format, true);
	binder.registerCustomEditor(Date.class, editor);
	}
	
	@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public BillableResponse addBillableEmp(@RequestBody Billable billEmp) {
		BillableResponse response = new BillableResponse();
		if (service.insert(billEmp)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully stored..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully stored..");
		}
		return response;
	}
	
	@DeleteMapping(path = "/delete/{bId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BillableResponse deleteEmp(@PathVariable("bId") int bId) {
		BillableResponse response = new BillableResponse();
		if (service.delete(bId)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully deleted..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully deleted..");
		}
		return response;
	}
	@GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public BillableResponse getAll() {
		BillableResponse response = new BillableResponse();
		List<Billable> list = service.getAllBillable();
		if (list == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully retrived");
			response.setEmpBill(list);
		}
		return response;
	}
	
	@PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public BillableResponse updateEmp(@RequestBody Billable bill) {
		BillableResponse response = new BillableResponse();
		if (service.update(bill)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully updated..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully updated..");
		}
		return response;
	}
}
