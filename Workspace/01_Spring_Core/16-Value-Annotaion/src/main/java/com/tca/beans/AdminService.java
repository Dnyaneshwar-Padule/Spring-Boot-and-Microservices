package com.tca.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

	/*
	 	@Value is used to inject values for primitive data type (String, int, char, float, double, long, short, boolean)
	 */
	
	@Value("http://admin.tca.com")
	private String url;
	
	@Value("8081")
	private Integer port;
	
	@Value("TCA-ADMIN")
	private String userName;
	
	@Value("ADMIN@TCA")
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminService [url=" + url + ", port=" + port + ", userName=" + userName + ", password=" + password
				+ "]";
	}
	
}
