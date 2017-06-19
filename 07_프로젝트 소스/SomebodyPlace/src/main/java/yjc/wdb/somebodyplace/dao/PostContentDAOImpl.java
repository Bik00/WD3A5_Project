package yjc.wdb.somebodyplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.somebodyplace.bean.PostContent;

@Repository
public class PostContentDAOImpl implements PostContentDAO {

	@Inject
	private SqlSession sql;
	private static final String NAMESPACE = "yjc.wdb.somebodyplace.PostContentMapper";
	
	@Override
	public void insert(PostContent postcontent) throws Exception {
		sql.insert(NAMESPACE + ".insertPostContent", postcontent);
	}

	@Override
	public List<PostContent> selectPostContent(int post_code) throws Exception {
		return sql.selectList(NAMESPACE + ".selectPostContent", post_code);
	}

}
