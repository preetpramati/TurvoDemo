package com.fk.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fk.dao.ILoginDAO;
import com.fk.dto.LoginDTO;
import com.fk.dto.MemberDTO;


public interface ILoginService {

	public MemberDTO getMember(Long id);
	
	public MemberDTO login(LoginDTO login);

	public Boolean validate(MemberDTO member);
	
}
