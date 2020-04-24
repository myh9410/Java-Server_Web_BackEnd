package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProductDto;
import util.DBUtil;

public class ProductDaoImpl implements ProductDao {

	@Override
	public ProductDto insert(String prod_name, int prod_price, String prod_desc) throws SQLException {
		ProductDto productDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into product (prod_name,prod_price,prod_desc) \n");
			sql.append("values(?,?,?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, prod_name);
			pstmt.setInt(2, prod_price);
			pstmt.setString(3, prod_desc);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return productDto;
	}

	@Override
	public List<ProductDto> listProduct(String key, String value) throws SQLException {
		List<ProductDto> list = new ArrayList<ProductDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if (value.equals("")) {
			try {
				conn = DBUtil.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append("select prod_no,prod_name,prod_price,prod_desc \n");
				sql.append("from product \n");
				sql.append("order by prod_no desc \n");
				pstmt = conn.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					ProductDto productDto = new ProductDto();
					productDto.setProd_no(rs.getInt("prod_no"));
					productDto.setProd_name(rs.getString("prod_name"));
					productDto.setProd_price(rs.getInt("prod_price"));
					productDto.setProd_desc(rs.getString("prod_desc"));
					
					list.add(productDto);
				}
			}finally {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
				DBUtil.close(conn);
			}
		} else if (value !="" && key.equals("prod_name")) { // 상품 명으로 검색
			try {
				conn = DBUtil.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append("select prod_no,prod_name,prod_price,prod_desc \n");
				sql.append("from product \n");
				sql.append("where prod_name = ? \n");
				sql.append("order by prod_no desc \n");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, value);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					ProductDto productDto = new ProductDto();
					productDto.setProd_no(rs.getInt("prod_no"));
					productDto.setProd_name(rs.getString("prod_name"));
					productDto.setProd_price(rs.getInt("prod_price"));
					productDto.setProd_desc(rs.getString("prod_desc"));
					
					list.add(productDto);
				}
			}finally {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
				DBUtil.close(conn);
			}
		} else if (value !="" && key.equals("under_prod_price")) {
			try {
				conn = DBUtil.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append("select prod_no,prod_name,prod_price,prod_desc \n");
				sql.append("from product \n");
				sql.append("where prod_price <= ? \n");
				sql.append("order by prod_no desc \n");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, value);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					ProductDto productDto = new ProductDto();
					productDto.setProd_no(rs.getInt("prod_no"));
					productDto.setProd_name(rs.getString("prod_name"));
					productDto.setProd_price(rs.getInt("prod_price"));
					productDto.setProd_desc(rs.getString("prod_desc"));
					
					list.add(productDto);
				}
			}finally {
				DBUtil.close(rs);
				DBUtil.close(pstmt);
				DBUtil.close(conn);
			}
		}
		return list;
	}

	@Override
	public void remove(String prod_name) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from product where prod_name = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, prod_name);
			pstmt.executeUpdate();
		}finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

}
