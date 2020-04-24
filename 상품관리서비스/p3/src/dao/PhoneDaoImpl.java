package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PhoneDto;
import util.DBUtil;




public class PhoneDaoImpl implements PhoneDao {

	@Override
	public void register(PhoneDto phoneDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into Phones(num,model,price,vcode) \n");
			sql.append("values(?,?,?,?) \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, phoneDto.getNum());
			pstmt.setString(2, phoneDto.getModel());
			pstmt.setInt(3, phoneDto.getPrice());
			pstmt.setString(4, phoneDto.getVcode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public List<PhoneDto> getlist() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PhoneDto> list = new ArrayList<PhoneDto>();
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select num,model,price,vcode \n");
			sql.append("from Phones order by price \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PhoneDto phoneDto = new PhoneDto();
				phoneDto.setModel(rs.getString("model"));
				phoneDto.setNum(rs.getString("num"));
				phoneDto.setPrice(rs.getInt("price"));
				phoneDto.setVcode(rs.getString("vcode"));
				
				list.add(phoneDto);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public List<PhoneDto> remove(String[] tmp) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PhoneDto> list = new ArrayList<PhoneDto>();
		for (int i = 0; i < tmp.length; i++) {
			String s = tmp[i];
			try {
				conn = DBUtil.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append("delete from Phones \n");
				sql.append("where num = ? \n");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, s);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		DBUtil.close(rs);
		DBUtil.close(pstmt);
		DBUtil.close(conn);
		return getlist();
	}

}
