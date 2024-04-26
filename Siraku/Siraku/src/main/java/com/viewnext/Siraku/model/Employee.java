package com.viewnext.Siraku.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String empNo;
	
	private String firstName;
	private String midinit;
	private String lastName;
	private Department workDept;
	private String phoneNo;
	private Date hireDate;
	private String job;
	private Short edLevel;
	private String sex;
	private Date birthDate;
	private Float salary;
	private Float bonus;
	private Float comm;
	
	@Override
	public int hashCode() {
		return Objects.hash(empNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empNo, other.empNo);
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empNo + ", firstName=" + firstName + ", midinit=" + midinit + ", lastName="
				+ lastName + ", workDept=" + workDept + ", phoneNo=" + phoneNo + ", hireDate=" + hireDate + ", job="
				+ job + ", edLevel=" + edLevel + ", sex=" + sex + ", birthDate=" + birthDate + ", salary=" + salary
				+ ", bonus=" + bonus + ", comm=" + comm + "]";
	}
	
	
}
