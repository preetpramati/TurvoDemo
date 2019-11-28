package com.fk.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.dao.ILoginDAO;
import com.fk.dto.LoginDTO;
import com.fk.dto.MemberDTO;
import com.fk.service.ILoginService;

@Service
public class LoginService implements ILoginService{

	@Autowired
	ILoginDAO loginDAO;

	public MemberDTO getMember(Long id) {
		// TODO Auto-generated method stub
		
		 return loginDAO.findById(id).get();
	}
	
	
	public MemberDTO login(LoginDTO login) {
		// TODO Auto-generated method stub
		
		 MemberDTO member = loginDAO.findByUserName(login.getUserName()).get();
		 if(member.getPassword().equals(login.getPassword()))
		 {
			 member.setToken(UUID.randomUUID().toString());
			 int updatedResult = loginDAO.updateToken(member);
			 return member;
		 }
		 return member;
	}


	public Boolean validate(MemberDTO member) {
		MemberDTO fetchedMember = loginDAO.findById(member.getMemberId()).get();
		if(fetchedMember.getToken().equalsIgnoreCase(member.getToken()) && member.isRegisteredForSale())
		{
			return true;
		}
		return false;
	}
	
}
