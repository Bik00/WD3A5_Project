package yjc.wdb.somebodyplace.service;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Product;

public interface ProductService {
	public void insert(Product product) throws Exception;
	public List<Product> selectProductList(int place_code) throws Exception;
	public Product selectProduct(int product_code) throws Exception;
}
