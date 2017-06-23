package yjc.wdb.somebodyplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.somebodyplace.bean.Post;

@Repository
public class PostDAOImpl implements PostDAO {

	@Inject
	private SqlSession sql;
	private static final String NAMESPACE = "yjc.wdb.somebodyplace.PostMapper";
	
	@Override
	public void insert(Post post) throws Exception {
		sql.insert(NAMESPACE + ".insertPost", post);
	}

	@Override
	public int selectPostCode(int product_code) throws Exception {
		return sql.selectOne(NAMESPACE + ".selectPostCode", product_code);
	}

	@Override
	public List<Integer> selectProductCode(int board_code) throws Exception {
		return sql.selectList(NAMESPACE + ".selectProductCode", board_code);
	}

	@Override
	public String searchType(int product_code) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(NAMESPACE + ".searchType", product_code);
	}

}
