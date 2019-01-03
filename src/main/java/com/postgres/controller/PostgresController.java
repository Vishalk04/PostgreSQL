package com.postgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgres.dao.PostgreSQLJDBC;

@RestController
public class PostgresController {

@Autowired
PostgreSQLJDBC postgreSqlJDBC;
	
	@GetMapping("/postgres")
	public String getId() {
		return postgreSqlJDBC.getData();
	}
}
