package com.ktds.framework.common.errorMgmt;

import java.io.Serializable;

/**
 * Exception 정보를 JSON Object로 반환
 * 
 * @author SW기술연구소
 * @since 2015. 05. 01
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자                수정내용
 *  -------    --------    ---------------------------
 *  2015.05.01 SW기술연구소              최초생성
 * 
 * </pre>
 */
public class ExceptionJson implements Serializable{
	private static final long serialVersionUID = 7729714952397704733L;

    private String url;
    private int statusCode;
    private String className;
    private String message;
    
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ExceptionJson [url=" + url + ", statusCode=" + statusCode
				+ ", className=" + className + ", message=" + message + "]";
	}
}
