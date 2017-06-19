package yjc.wdb.somebodyplace.dao;

import java.util.List;

import yjc.wdb.somebodyplace.bean.PostContent;

public interface PostContentDAO {
	public void insert(PostContent post_content) throws Exception;
	public List<PostContent> selectPostContent(int post_code) throws Exception;
}
