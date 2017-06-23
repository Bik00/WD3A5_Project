package yjc.wdb.somebodyplace.dao;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Detail;
import yjc.wdb.somebodyplace.bean.Product;

public interface ProductDAO {
	public void insert(Product product) throws Exception;
	public List<Product> selectProductList(int place_code) throws Exception;
	public Product selectProduct(int product_code) throws Exception;
	public List<Product> selectAllProduct();
	public List<Product> selectProductByDcate(int dcate_code);
	public Detail selectDetailInfo(int parseInt);
}