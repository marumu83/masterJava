package com.viewnext.Siraku.modelFL;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentFL implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String deptNo;
	
	private String deptName;
	private String mgrno;
	private String admrDept;
	private String location;
	
	public DepartmentFL() {
		super();
	}
	
	public DepartmentFL(String deptNo, String deptName, String mgrno, String admrDept, String location) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.mgrno = mgrno;
		this.admrDept = admrDept;
		this.location = location;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getMgrno() {
		return mgrno;
	}

	public void setMgrno(String mgrno) {
		this.mgrno = mgrno;
	}

	public String getAdmrDept() {
		return admrDept;
	}

	public void setAdmrDept(String admrDept) {
		this.admrDept = admrDept;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deptNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentFL other = (DepartmentFL) obj;
		return Objects.equals(deptNo, other.deptNo);
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", mgrno=" + mgrno + ", admrDept=" + admrDept
				+ ", location=" + location + "]";
	}
	
}
