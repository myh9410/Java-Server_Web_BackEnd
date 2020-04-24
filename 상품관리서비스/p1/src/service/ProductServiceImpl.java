package service;

import java.util.List;

import dao.ProductDao;
import dao.ProductDaoImpl;
import model.ProductDto;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}
	
	@Override
	public void insertProduct(ProductDto productDto) throws Exception {
		if (productDto.getProd_name() == null || productDto.getProd_desc()== null)
			throw new Exception();
		productDao.insert(productDto.getProd_name(), productDto.getProd_price(), productDto.getProd_desc());
	}

	@Override
	public List<ProductDto> listProduct(String key, String value) throws Exception {
		return productDao.listProduct(key, value);
	}

	@Override
	public void removeProduct(String prod_name) throws Exception {
		if (prod_name.equals("")) throw new Exception();
		productDao.remove(prod_name);
	}

}
