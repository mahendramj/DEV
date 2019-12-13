package com.tyss.EngineersManagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.EngineersManagement.dto.Billable;
import com.tyss.EngineersManagement.dto.BillableResponse;
import com.tyss.EngineersManagement.dto.ClientsInfo;
import com.tyss.EngineersManagement.dto.ClientsInfoStatusCode;
import com.tyss.EngineersManagement.service.ClientsInfoService;
@RestController
@RequestMapping("/clientinfo")
public class ClientsInfoController {
	@Autowired
	private ClientsInfoService service;
	
	@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoStatusCode addclientsinfo(@RequestBody ClientsInfo clientsInfo) {
		ClientsInfoStatusCode response = new ClientsInfoStatusCode();
		if (service.insert(clientsInfo)) {
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
	@DeleteMapping(path = "/delete/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoStatusCode deleteclient(@PathVariable("clientId") int clientId) {
		ClientsInfoStatusCode response = new ClientsInfoStatusCode();
		if (service.delete(clientId)) {
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
	public ClientsInfoStatusCode getAll() {
		ClientsInfoStatusCode response = new ClientsInfoStatusCode();
		List<ClientsInfo> list = service.getAllClients();
		if (list == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully retrived");
			response.setClients(list);;
		}
		return response;
	}
	
	@PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoStatusCode updateBook(@RequestBody ClientsInfo cinfo) {
		ClientsInfoStatusCode response = new ClientsInfoStatusCode();
		if (service.update(cinfo)) {
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
