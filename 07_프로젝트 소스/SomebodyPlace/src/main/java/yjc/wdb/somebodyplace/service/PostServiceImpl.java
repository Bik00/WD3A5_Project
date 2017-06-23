package yjc.wdb.somebodyplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import yjc.wdb.somebodyplace.bean.Post;
import yjc.wdb.somebodyplace.dao.PostDAO;

@Service
public class PostServiceImpl implements PostService {

	@Inject
	private PostDAO dao;
	
	@Override
	public void insert(Post post) throws Exception {
		dao.insert(post);
	}

	@Override
	public int selectPostCode(int product_code) throws Exception {
		return dao.selectPostCode(product_code);
	}

	@Override
	public List<Integer> selectProductCode(int board_code) throws Exception {
		return dao.selectProductCode(board_code);
	}

	@Override
	public String searchType(int product_code) throws Exception {
		// TODO Auto-generated method stub
		return  dao.searchType(product_code);
	}

}
