package com.ktds.framework.sample.mybatis.service;

import java.util.List;

import com.ktds.framework.sample.mybatis.domain.Employee;

/**
 * EmployeeService
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
public interface EmployeeService {
	public List<Employee> selectList(Employee employee);
	public List<Employee> selectListbyDao(Employee employee);
	public int insertEmployee(Employee param);
	
	public Employee selectOne(String id);
}
