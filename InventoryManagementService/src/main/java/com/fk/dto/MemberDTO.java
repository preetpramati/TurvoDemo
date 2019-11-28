package com.fk.dto;

public class MemberDTO {

	
	Long memberId;
	String userName;
	String password;
	String token;
	Boolean isRegisteredForSale;
	
	public MemberDTO()
	{
		
	}

	public MemberDTO(Long memberId, String userName, String passowrd, String token, Boolean isRegisteredForSale)
	{
		this.memberId = memberId;
		this.userName = userName;
		this.password = passowrd;
		this.token = token;
		this.isRegisteredForSale = isRegisteredForSale;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean isRegisteredForSale() {
		return isRegisteredForSale;
	}

	public void setIsRegisteredForSale(Boolean isRegisteredForSale) {
		this.isRegisteredForSale = isRegisteredForSale;
	}
	
}
