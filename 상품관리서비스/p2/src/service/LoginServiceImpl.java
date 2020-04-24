package service;

import java.sql.SQLException;

import dao.LoginDAO;
import dao.LoginDAOImpl;
import dto.SsafyMember;

public class LoginServiceImpl implements LoginService {

	@Override
	public SsafyMember login(String id, String password) throws ClassNotFoundException, SQLException {
		LoginDAO dao = new LoginDAOImpl();
		SsafyMember dto = dao.login(id, password);
		return dto;
	}

}
