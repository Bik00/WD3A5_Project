package yjc.wdb.somebodyplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.somebodyplace.bean.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	private SqlSession sql;
	private static final String NAMESPACE = "yjc.wdb.somebodyplace.ProductMapper";
	
	@Override
	public void insert(Product product) throws Exception {
		sql.insert(NAMESPACE + ".insertProduct", product);
	}

	@Override
	public List<Product> selectProductList(int place_code) throws Exception {
		return sql.selectList(NAMESPACE + ".selectProductList", place_code);
	}

	@Override
	public Product selectProduct(int product_code) throws Exception {
		return sql.selectOne(NAMESPACE + ".selectProduct", product_code);
	}
	
}
