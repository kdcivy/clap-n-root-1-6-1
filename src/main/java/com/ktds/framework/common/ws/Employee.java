package com.ktds.framework.common.ws;

import java.io.Serializable;

/**
 * Employee
 * @author SW기술연구소
 * @since 2015.05.01
 * @version 1.0
 * 
 * <pre>
 * << 개정 이력 >>
 *	수정일		수정자		수정내용
 *	----------	----------	--------
 *	2015.05.01	SW기술연구소	최초생성
 *</pre>
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5678631330841098048L;
	
    private String empNo;
    
    private String empNm;
    
    private String hireDate;
    
    private String startDate;
    
    private String endDate;

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empNm=" + empNm + ", hireDate="
				+ hireDate + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
    
}
