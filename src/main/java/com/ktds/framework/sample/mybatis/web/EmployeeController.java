package com.ktds.framework.sample.mybatis.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktds.framework.sample.mybatis.domain.Employee;
import com.ktds.framework.sample.mybatis.service.EmployeeService;

/**
 * EmployeeController
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

@Controller("employeeController")
public class EmployeeController {
	 protected final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	 
	@Autowired
	@Qualifier("mybatisEmployeeService")
	private EmployeeService employeeService;
	
	/**
	 * 확장자 .json으로 호출하는 경우 MappingJackson2JsonView 를 통해서 json 형태로 응답하는 경우
	 * @param	n/a
	 * @return	Employee Collection
	 * @exception	n/a
	*/
	@RequestMapping(value = "/sample/employeeList1", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Employee> getSelectListOne(){
		List<Employee> result = employeeService.selectList(new Employee());

		return result;
	}
	
	/**
	 * @Controller + @ResponseBody 조합의 의해서 json 형태로 응답하는 경우, RequestResponseBodyMethodProcessor
	 * @param	n/a
	 * @return	Employee Collection
	 * @exception	n/a
	*/
	@RequestMapping(value = "/sample/employeeList2", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody List<Employee> getSelectListTwo(){
		List<Employee> result = employeeService.selectList(new Employee());

		return result;
	}
	/**
	 * @ mybatis dao 방식의 조회
	 * @param	n/a
	 * @return	Employee Collection
	 * @exception	n/a
	*/
	@RequestMapping(value = "/employee/employeeListDao", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody List<Employee> getSelectListDao(){
		logger.debug("[EmployeeController] selectListbyDao is invoked.");
		List<Employee> result = employeeService.selectListbyDao(null);

		return result;
	}
	
	/**
	 * @ Employee 등록
	 * @param	n/a
	 * @return	n/a
	 * @exception	n/a
	*/
	@RequestMapping(value = "/employee/insertEmployee", method = { RequestMethod.POST, RequestMethod.GET })
	public void insertEmployee(){
		Employee my = new Employee();
		my.setEmpNo("200509");
		my.setEmpNm("이창건");
		my.setHireDate("20050901");
		
		logger.debug("insertEmployee() rows=" + employeeService.insertEmployee(my) );
		logger.debug("insertEmployee() rows=" + employeeService.insertEmployee(my) );
	}
}
