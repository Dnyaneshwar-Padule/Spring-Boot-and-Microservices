package com.tca.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

	
	@Value("${admin.url}")
	private String url;
	
	@Value("${admin.port}")
	private Integer port;
	
	@Value("${admin.userName}")
	private String userName;
	
	@Value("${admin.password}")
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
