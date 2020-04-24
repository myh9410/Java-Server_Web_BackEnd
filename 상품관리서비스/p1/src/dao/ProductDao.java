package dao;

import java.sql.SQLException;
import java.util.List;

import model.ProductDto;

public interface ProductDao {
	public ProductDto insert(String prod_name, int prod_price, String prod_desc) throws SQLException;
	public List<ProductDto> listProduct(String key, String value) throws SQLException;
	public void remove(String prod_name) throws SQLException;
}
