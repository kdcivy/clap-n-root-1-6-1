package com.ktds.framework.sample.mybatis.service;

import java.util.List;

import com.ktds.framework.sample.mybatis.domain.ErrorMgmt;

/**
 * ErrorMgmtService
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
public interface ErrorMgmtService {
	
    public List<ErrorMgmt> select(ErrorMgmt errorMgmtVO) ;
}
