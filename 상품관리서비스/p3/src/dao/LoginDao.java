package dao;

import java.sql.SQLException;

import dto.MemberDto;


public interface LoginDao {

	public MemberDto login(String userid, String userpwd) throws SQLException;

	public String findpwd(String userid, String username, String email) throws SQLException;
	
}
