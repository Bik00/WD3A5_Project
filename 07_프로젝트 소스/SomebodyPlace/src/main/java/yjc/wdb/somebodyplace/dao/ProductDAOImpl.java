package yjc.wdb.somebodyplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.somebodyplace.bean.Detail;
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
	
	@Override
	public List<Product> selectAllProduct() {
		// TODO Auto-generated method stub
		return sql.selectList(NAMESPACE + ".selectAllProduct");
	}

	@Override
	public List<Product> selectProductByDcate(int dcate_code) {
		// TODO Auto-generated method stub
		return sql.selectList(NAMESPACE + ".selectProductByDcate", dcate_code);
	}

	@Override
	public Detail selectDetailInfo(int parseInt) {
		// TODO Auto-generated method stub
		return sql.selectOne(NAMESPACE+".selectDetailInfo", parseInt);
	}
}
