package com.tca.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Value("${email.smtpHost}")
	private String smtpHost;
	
	@Value("${email.port}")
	private Integer port;
	
	@Value("${email.toAddress}")
	private String toAddress;
	
	@Value("${email.fromAddress}")
	private String fromAddress;

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	@Override
	public String toString() {
		return "EmailService [smtpHost=" + smtpHost + ", port=" + port + ", toAddress=" + toAddress + ", fromAddress="
				+ fromAddress + "]";
	}
}
