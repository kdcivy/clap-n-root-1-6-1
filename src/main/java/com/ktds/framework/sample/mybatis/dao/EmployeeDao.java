package com.ktds.framework.sample.mybatis.dao;

import java.util.List;

import com.ktds.framework.sample.mybatis.domain.Employee;

/**
 * EmployeeDao
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
public interface EmployeeDao {
	public List<Employee> selectList(Employee param);
}
