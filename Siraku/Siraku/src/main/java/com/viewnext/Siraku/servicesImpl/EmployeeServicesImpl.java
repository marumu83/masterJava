package com.viewnext.Siraku.servicesImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.viewnext.Siraku.modelFL.DepartmentFL;
import com.viewnext.Siraku.modelFL.EmployeeFL;
import com.viewnext.Siraku.service.EmployeeServices;

@Service
public class EmployeeServicesImpl implements EmployeeServices{
	
	@Override
	public List<EmployeeFL> obtenerEmpleadoByDeptNo(@PathVariable String codDept) {
		List<EmployeeFL> empleados = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE WORKDEPT = '"+codDept+"'");
			
			while(result.next()) {
				empleados.add(new EmployeeFL(result.getString(1), result.getString(2),
						result.getString(3), result.getString(4),(DepartmentFL) result.getObject(5),
						result.getString(6), result.getDate(7), result.getString(8), result.getShort(9),
						result.getString(10), result.getDate(11), result.getFloat(12),
						result.getFloat(13), result.getFloat(14)));
			}
			return empleados;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String deleteEmpleado(@PathVariable Integer codEmpleado) {
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
			Statement statement = connection.createStatement();
			
			return Integer.toString(statement.executeUpdate("DELETE FROM EMPLOYEE WHERE EMPNO = " + codEmpleado));
		} catch (SQLException e) {
			e.printStackTrace();
			return "Ocurrio un error";
		}
		
	}
	
	@Override
	public String subirSueldoEmpleado(@PathVariable Integer codEmpleado) {
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
			Statement statement = connection.createStatement();
			
			if (statement.executeUpdate("UPDATE EMPLOYEE SET salary = salary * 1.1 WHERE EMPNO = " + codEmpleado) > 0) {
				return "Se le subió el sueldo al empleado " + codEmpleado + " correctamente";
			}else {
				return "No se encontró al empleado";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Ocurrio un error";
		}
	}
}
