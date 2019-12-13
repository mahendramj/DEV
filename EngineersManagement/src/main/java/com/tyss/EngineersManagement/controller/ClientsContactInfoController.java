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

import com.tyss.EngineersManagement.dto.ClientContactInfo;
import com.tyss.EngineersManagement.dto.ClientContactStatusCode;
import com.tyss.EngineersManagement.service.ClientContactInfoService;

@RestController
@RequestMapping("/clicont")
public class ClientsContactInfoController {
	
	
		@Autowired
		private ClientContactInfoService service;

		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			CustomDateEditor editor = new CustomDateEditor(format, true);
			binder.registerCustomEditor(Date.class, editor);
		}

		@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
		public ClientContactStatusCode add(@RequestBody ClientContactInfo cInfo) {
			ClientContactStatusCode response = new ClientContactStatusCode();
			if (service.addClientCont(cInfo)) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("data  successfully stored..");
			} else {
				response.setStatusCode(400);
				response.setMessage("failure");
				response.setDescription("data not successfully stored..");
			
			}
			return response;
		}

		@PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
		public ClientContactStatusCode updateBook(@RequestBody ClientContactInfo cInfo) {
			ClientContactStatusCode response = new ClientContactStatusCode();
			if (service.updateClientCont(cInfo)) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("data  successfully updated..");
			} else {
				response.setStatusCode(400);
				response.setMessage("failure");
				response.setDescription("data not successfully updated..");
			}
			return response;
		}

		@DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ClientContactStatusCode deleteUser(@PathVariable int cInfoId) {
			ClientContactStatusCode response = new ClientContactStatusCode();
			if (service.deleteClientCont(cInfoId)) {
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

		@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
		public ClientContactStatusCode getAll() {
			ClientContactStatusCode response = new ClientContactStatusCode();
			List<ClientContactInfo> list = service.getClientCont();
			if (list == null) {
				response.setStatusCode(400);
				response.setMessage("failure");
				response.setDescription("data not successfully retrived..");
			} else {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("data  successfully retrived");
				response.setClients(list);;
			}
			return response;
		}
	}

