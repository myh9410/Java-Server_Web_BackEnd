package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.SsafyMember;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public SsafyMember login(String id_from_view, String pwd_from_view) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
		String user = "ssafy";
		String password = "ssafy";
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select userid, username, userpwd, email, address, joindate from ssafy_member"
				+ " where userid = ? and userpwd = ?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, id_from_view);
		psmt.setString(2, pwd_from_view);
		ResultSet rs = psmt.executeQuery();

		SsafyMember dto = null;
		while(rs.next()) {
			dto = new SsafyMember();
			dto.setUserid(rs.getString("userid"));
			dto.setUsername(rs.getString("username"));
			dto.setUserpwd(rs.getString("userpwd"));
			dto.setEmail(rs.getString("email"));
			dto.setAddress(rs.getString("address"));
			dto.setJoindate(rs.getString("joindate"));
		}
		rs.close();
		psmt.close();
		con.close();

		return dto;
	}

}









