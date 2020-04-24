package service;

import dao.LoginDao;
import dao.LoginDaoImpl;
import dto.MemberDto;

public class LoginServiceImpl implements LoginService {

	LoginDao loginDao;
	
	public LoginServiceImpl() {
		loginDao = new LoginDaoImpl();
	}
	
	@Override
	public MemberDto login(String userid, String userpwd) throws Exception {
		if (userid == null || userpwd == null)
			throw new Exception();
		return loginDao.login(userid, userpwd);
	}

	@Override
	public String findpwd(String userid, String username, String email) throws Exception {
		if (userid == null || username == null || email == null) throw new Exception();
		return loginDao.findpwd(userid,username,email);
	}
	
}
