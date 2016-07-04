/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ktds.framework.common.errorMgmt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsframework.core.mvc.BaseController;

/**
 * Error Controller 웹 에러 발생시 에러 페이지로 넘겨준다.
 * 
 * @author SW기술연구소
 * @since 2013. 06. 10
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자                수정내용
 *  -------    --------    ---------------------------
 *  2013.06.10 SW기술연구소              최초생성
 * 
 * </pre>
 */

@Controller
public class ErrorController extends BaseController {
    protected final Logger logger = LoggerFactory.getLogger(ErrorController.class);
    
    @RequestMapping(value = "/error.do", method = { RequestMethod.POST, RequestMethod.GET })
    public ExceptionJson getError(HttpServletRequest request, HttpServletResponse response,Exception ex) {
    	logger.debug("========================= ErrorController is called. =========================");
    	ex.printStackTrace();
    	
    	
    	ExceptionJson exJson = new ExceptionJson();
    	exJson.setUrl(request.getRequestURL().toString());
    	exJson.setClassName(ex.getClass().toString());
    	exJson.setStatusCode(response.getStatus());
    	exJson.setMessage(ex.getMessage());
    	
    	return exJson;
    }
}
