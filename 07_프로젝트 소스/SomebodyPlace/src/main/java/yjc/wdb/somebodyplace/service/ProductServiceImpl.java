package yjc.wdb.somebodyplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import yjc.wdb.somebodyplace.bean.Product;
import yjc.wdb.somebodyplace.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject
	private ProductDAO dao;
	
	@Override
	public void insert(Product product) throws Exception {
		dao.insert(product);
	}

	@Override
	public List<Product> selectProductList(int place_code) throws Exception {
		return dao.selectProductList(place_code);
	}

	@Override
	public Product selectProduct(int product_code) throws Exception {
		return dao.selectProduct(product_code);
	}

}
