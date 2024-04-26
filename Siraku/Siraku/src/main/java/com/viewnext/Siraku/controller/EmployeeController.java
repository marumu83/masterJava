package com.viewnext.Siraku.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.Siraku.modelFL.EmployeeFL;
import com.viewnext.Siraku.service.EmployeeServices;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeService;
	
	@GetMapping("/employees/dept/{codDept}")
	public List<EmployeeFL> obtenerEmpleadoByDeptNo(@PathVariable String codDept) {
		return employeeService.obtenerEmpleadoByDeptNo(codDept);
	}
	
	@GetMapping("employees/delete/{codEmpleado}")
	public String deleteEmpleado(@PathVariable Integer codEmpleado) {
		return employeeService.deleteEmpleado(codEmpleado);
	}
	
	@GetMapping("employees/subirSueldo/{codEmpleado}")
	public String subirSueldoEmpleado(@PathVariable Integer codEmpleado) {
		return employeeService.subirSueldoEmpleado(codEmpleado);
	}
}
