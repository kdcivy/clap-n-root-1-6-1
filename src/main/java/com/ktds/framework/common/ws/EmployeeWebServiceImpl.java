package com.ktds.framework.common.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ktds.framework.sample.mybatis.service.EmployeeService;

@WebService(endpointInterface = "com.ktds.framework.common.ws.EmployeeWebService")
public class EmployeeWebServiceImpl implements EmployeeWebService {

	@Autowired
	@Qualifier("mybatisEmployeeService")
	EmployeeService EmployeeService;
	
	@Override
	public Employee selectOne(@WebParam(name = "id") String id) {
		// TODO Auto-generated method stub
		// 기존 Back-end 서비스 Layer에 있는 서비스 호출
		com.ktds.framework.sample.mybatis.domain.Employee employee = EmployeeService.selectOne(id);
		com.ktds.framework.common.ws.Employee employeeWs = new com.ktds.framework.common.ws.Employee();
		
		// mybatis로 가져온 Employee VO를 CXF 응답용 Employee 로 생성,CXF는 JAXB를 이용하여 xml로 변환함
		employeeWs.setEmpNo(employee.getEmpNo());
		employeeWs.setEmpNm(employee.getEmpNm());
		employeeWs.setStartDate(employee.getStartDate());
		employeeWs.setHireDate(employee.getHireDate());
		
		return employeeWs;
	}

}
