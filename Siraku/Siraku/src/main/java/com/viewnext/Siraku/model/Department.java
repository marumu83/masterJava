package com.viewnext.Siraku.model;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable{
	private static final long serialVersionUID = 1L;

	private String deptNo;
	private String deptName;
	private String mgrno;
	private String admrDept;
	private String location;

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
		Department other = (Department) obj;
		return Objects.equals(deptNo, other.deptNo);
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", mgrno=" + mgrno + ", admrDept=" + admrDept
				+ ", location=" + location + "]";
	}
	
}
