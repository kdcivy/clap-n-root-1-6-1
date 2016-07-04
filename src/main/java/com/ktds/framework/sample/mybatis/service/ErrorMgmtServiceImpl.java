package com.ktds.framework.sample.mybatis.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktds.framework.sample.mybatis.domain.ErrorMgmt;
import com.ktds.framework.sample.mybatis.persistence.ErrorMgmtMapper;

/**
 * ErrorMgmtServiceImpl
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
@Service("errorMgmtService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class}, value="ppas")
public class ErrorMgmtServiceImpl implements ErrorMgmtService {
	private static Logger logger = LoggerFactory.getLogger(ErrorMgmtServiceImpl.class);
	
	@Autowired
	private ErrorMgmtMapper errorMgmtMapper;
	
	@Override
	public List<ErrorMgmt> select(ErrorMgmt errorMgmtVO) {
		// TODO Auto-generated method stub
		//List<ErrorMgmt> errors = errorMgmtMapper.selectList(errorMgmtVO, new RowBounds(0,10));
		List<ErrorMgmt> errors = errorMgmtMapper.selectList(errorMgmtVO);
		for(ErrorMgmt error : errors){
			logger.debug(error.toString());
		}
		
		return errors;
	}
}
