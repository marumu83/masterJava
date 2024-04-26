package com.viewnext.Siraku.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.viewnext.Siraku.modelFL.EmployeeFL;

public interface EmployeeServices {
	public List<EmployeeFL> obtenerEmpleadoByDeptNo(String codDept);
	public String deleteEmpleado(@PathVariable Integer codEmpleado);
	public String subirSueldoEmpleado(@PathVariable Integer codEmpleado);
}
