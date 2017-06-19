package yjc.wdb.somebodyplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import yjc.wdb.somebodyplace.bean.PostContent;
import yjc.wdb.somebodyplace.dao.PostContentDAO;

@Service
public class PostContentServiceImpl implements PostContentService {

	@Inject
	private PostContentDAO dao;
	
	@Override
	public void insert(PostContent post_content) throws Exception {
		dao.insert(post_content);
	}

	@Override
	public List<PostContent> selectPostContent(int post_code) throws Exception {
		return dao.selectPostContent(post_code);
	}

}
