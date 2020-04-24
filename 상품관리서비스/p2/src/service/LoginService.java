package service;

import java.sql.SQLException;

import dto.SsafyMember;

public interface LoginService {

	public abstract SsafyMember login(String id, String password) throws ClassNotFoundException, SQLException;

}
