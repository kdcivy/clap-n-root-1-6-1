package com.ktds.framework.common.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface EmployeeWebService {
	public Employee selectOne(@WebParam(name="id")String id);
}
