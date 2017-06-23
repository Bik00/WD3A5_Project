package yjc.wdb.somebodyplace.service;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Post;

public interface PostService {
	public void insert(Post post) throws Exception;
	public int selectPostCode(int product_code) throws Exception;
	public String searchType(int product_code) throws Exception;
	public List<Integer> selectProductCode(int board_code) throws Exception;
}
