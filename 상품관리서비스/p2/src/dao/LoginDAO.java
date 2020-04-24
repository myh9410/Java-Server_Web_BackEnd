package dao;

import java.sql.SQLException;

import dto.SsafyMember;

public interface LoginDAO {

	public abstract SsafyMember login(String id, String password) throws ClassNotFoundException, SQLException;

}
