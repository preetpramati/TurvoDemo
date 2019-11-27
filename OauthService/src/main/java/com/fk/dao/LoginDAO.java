package com.fk.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fk.dto.MemberDTO;

@Repository
public class LoginDAO {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Optional<MemberDTO> findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from MemberLogin where memberid = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new MemberDTO(
                                rs.getLong("memberid"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("token")
                        ))
        );
    }
	
	
	public Optional<MemberDTO> findByUserName(String userName) {
        return jdbcTemplate.queryForObject(
                "select * from MemberLogin where username = ?",
                new Object[]{userName},
                (rs, rowNum) ->
                        Optional.of(new MemberDTO(
                                rs.getLong("memberid"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("token")
                        ))
        );
    }


	public int updateToken(MemberDTO member) {
		// TODO Auto-generated method stub
		
		 return jdbcTemplate.update(
	                "update MemberLogin set token = ? where memberid = ?",
	                member.getToken(), member.getMemberId());
		
	}
	
	
}
