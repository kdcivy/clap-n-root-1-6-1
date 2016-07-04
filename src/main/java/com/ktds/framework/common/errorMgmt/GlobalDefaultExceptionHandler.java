package com.ktds.framework.common.errorMgmt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	private final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);
	
    @ExceptionHandler(value = {Exception.class, RuntimeException.class, SQLException.class, IOException.class})
    public ModelAndView defaultErrorHandler(HttpServletRequest req,HttpServletResponse res, Exception ex) throws Exception{
    	logger.debug("========================= GlobalDefaultExceptionHandler is called. =========================");
    	
    	res.setStatus(303);
        ModelAndView mav = new ModelAndView();
        mav.addObject("datetime", new Date());
        //mav.addObject("exception", ex);
        mav.addObject("messge", ex.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("jsonView");
        
        return mav;
    }
}
