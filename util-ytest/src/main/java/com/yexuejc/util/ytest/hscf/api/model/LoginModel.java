package com.yexuejc.util.ytest.hscf.api.model;

import java.io.Serializable;

/**
 * 车辆检测报告
 * 
 * @author pengh
 *
 */
public class LoginModel implements Serializable{
	
	private static final long serialVersionUID = -5498913458130805040L;
	
	private String username;
	
	private String password;
	/**验证码登录*/
	private String sessionid;
	private String passcode;
	
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
