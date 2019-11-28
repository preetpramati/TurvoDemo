package com.fk.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fk.dto.MemberDTO;


public interface ILoginDAO {
	
	public Optional<MemberDTO> findById(Long id);
	public Optional<MemberDTO> findByUserName(String userName);
	public int updateToken(MemberDTO member);

}
