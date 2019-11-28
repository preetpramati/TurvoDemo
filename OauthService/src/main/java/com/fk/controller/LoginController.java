package com.fk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fk.dto.LoginDTO;
import com.fk.dto.MemberDTO;
import com.fk.service.ILoginService;

@RestController
public class LoginController {
	
	
	@Autowired
	ILoginService loginService;

	 @RequestMapping(value="/login", method = RequestMethod.POST)
	    public MemberDTO login(@RequestBody LoginDTO loginDTO) {
		 
		 MemberDTO member = loginService.login(loginDTO);
	        return member;
	    }
	 
	 @RequestMapping(value="/validate", method = RequestMethod.POST)
	    public Boolean validate(@RequestBody MemberDTO member) {
		 
		 Boolean isValid = loginService.validate(member);
	        return isValid;
	    }
	 
	 @RequestMapping(value="/getDetails/{id}", method = RequestMethod.GET )
	    public MemberDTO getMember(@PathVariable("id") Long id) {
		 
		 return loginService.getMember(id);
		 
	    }
}
