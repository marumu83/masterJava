package com.viewnext.Siraku.modelFL;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeFL implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String empNo;
	
	private String firstName;
	private String midinit;
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name = "work_dept")
	private DepartmentFL workDept;
	
	private String phoneNo;
	private Date hireDate;
	private String job;
	private Short edLevel;
	private String sex;
	private Date birthDate;
	private Float salary;
	private Float bonus;
	private Float comm;
	
	public EmployeeFL() {
		
	}

	/**
	 * @param empNo
	 * @param firstName
	 * @param midinit
	 * @param lastName
	 * @param workDept
	 * @param phoneNo
	 * @param hireDate
	 * @param job
	 * @param edLevel
	 * @param sex
	 * @param birthDate
	 * @param salary
	 * @param bonus
	 * @param comm
	 */
	public String getEmpno() {
		return empNo;
	}
	/**
	 * @param empNo
	 * @param firstName
	 * @param midinit
	 * @param lastName
	 * @param workDept
	 * @param phoneNo
	 * @param hireDate
	 * @param job
	 * @param edLevel
	 * @param sex
	 * @param birthDate
	 * @param salary
	 * @param bonus
	 * @param comm
	 */
	public EmployeeFL(String empNo, String firstName, String midinit, String lastName, DepartmentFL workDept,
			String phoneNo, Date hireDate, String job, Short edLevel, String sex, Date birthDate, Float salary,
			Float bonus, Float comm) {
		this.empNo = empNo;
		this.firstName = firstName;
		this.midinit = midinit;
		this.lastName = lastName;
		this.workDept = workDept;
		this.phoneNo = phoneNo;
		this.hireDate = hireDate;
		this.job = job;
		this.edLevel = edLevel;
		this.sex = sex;
		this.birthDate = birthDate;
		this.salary = salary;
		this.bonus = bonus;
		this.comm = comm;
	}

	public void setEmpno(String empno) {
		this.empNo = empno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMidinit() {
		return midinit;
	}
	public void setMidinit(String midinit) {
		this.midinit = midinit;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public DepartmentFL getWorkDept() {
		return workDept;
	}

	public void setWorkDept(DepartmentFL workDept) {
		this.workDept = workDept;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Short getEdLevel() {
		return edLevel;
	}
	public void setEdLevel(Short edLevel) {
		this.edLevel = edLevel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}


	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	/**
	 * @return the salary
	 */
	public Float getSalary() {
		return salary;
	}


	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Float salary) {
		this.salary = salary;
	}


	/**
	 * @return the bonus
	 */
	public Float getBonus() {
		return bonus;
	}


	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(Float bonus) {
		this.bonus = bonus;
	}


	/**
	 * @return the comm
	 */
	public Float getComm() {
		return comm;
	}


	/**
	 * @param comm the comm to set
	 */
	public void setComm(Float comm) {
		this.comm = comm;
	}


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
		EmployeeFL other = (EmployeeFL) obj;
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
