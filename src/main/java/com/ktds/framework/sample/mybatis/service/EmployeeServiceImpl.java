package com.ktds.framework.sample.mybatis.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.ktds.framework.sample.mybatis.dao.EmployeeDao;
import com.ktds.framework.sample.mybatis.domain.Employee;
import com.ktds.framework.sample.mybatis.persistence.EmployeeMapper;

/**
 * EmployeeServiceImpl
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
@Service("mybatisEmployeeService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class}, value="ppas")
public class EmployeeServiceImpl implements EmployeeService {
	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	@Qualifier("employeeDao")
	private EmployeeDao employeeDao;
	
	/**
	 * Mybatis Mapper Interface 방식의 Select
	 * @param	Employee
	 * @return	Employee Collection
	 * @exception	n/a
	*/
	@Override
	public List<Employee> selectList(Employee employee) {
		// TODO Auto-generated method stub
		
		if (TransactionSynchronizationManager.isActualTransactionActive()) {
			   TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
			   logger.debug("TransactionStatus=" + status.toString());
			   
			   Map<Object,Object> resourceMap = TransactionSynchronizationManager.getResourceMap();
			   for (Map.Entry entry : resourceMap.entrySet()) {
				   logger.debug("Resource Map.Entry=" + entry.getKey() + ", " + entry.getValue());
				}
		}
		
		//List<Employee> employees = employeeMapper.selectList(employee,new RowBounds(0,1));
		List<Employee> employees = employeeMapper.selectList(employee);
		for(Employee person : employees){
			logger.debug(person.toString());
		}
		
		return employees;
	}
	/**
	 * Mybatis Mapper Interface 방식의 Insert
	 * @param	Employee
	 * @return	Employee Collection
	 * @exception	n/a
	*/
	@Override
	public int insertEmployee(Employee param) {
		// TODO Auto-generated method stub
		int rows = employeeMapper.insertEmployee(param);
		rows = employeeMapper.insertEmployee(param);
		
		return rows;
	}

	/**
	 * Mybatis Sqlsession Dao 방식의 Select
	 * @param	Employee
	 * @return	Employee Collection
	 * @exception	n/a
	*/
	@Override
	public List<Employee> selectListbyDao(Employee employee) {
		// TODO Auto-generated method stub
		logger.debug("[EmployeeServiceImpl] selectListbyDao is called.");
		
		List<Employee> employees = employeeDao.selectList(employee);
		for(Employee person : employees){
			logger.debug(person.toString());
		}
		return employees;
	}
	@Override
	public Employee selectOne(String id) {
		// TODO Auto-generated method stub
		logger.debug("[EmployeeServiceImpl] selectList(String id) is called.");
		
		return employeeMapper.selectOne(id);
	}

}
