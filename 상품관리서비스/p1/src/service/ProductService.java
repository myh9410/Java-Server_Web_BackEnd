package service;

import model.ProductDto;
import java.util.List;

public interface ProductService {
	public void insertProduct(ProductDto productDto) throws Exception;
	public List<ProductDto> listProduct(String key, String value) throws Exception;
	public void removeProduct(String prod_name) throws Exception;
}
