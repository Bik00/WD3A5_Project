package yjc.wdb.somebodyplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import yjc.wdb.somebodyplace.bean.Issue;
import yjc.wdb.somebodyplace.dao.IssueDAO;

@Service
public class IssueServiceImpl implements IssueService  {
	
	
	@Inject
	private IssueDAO dao;

	@Override
	public void regist(Issue b) throws Exception {
		// TODO Auto-generated method stub
		dao.create(b);
	}

	@Override
	public Issue read(int issue_code) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(issue_code);
	}

	@Override
	public void modify(Issue b) throws Exception {
		// TODO Auto-generated method stub
		dao.update(b);
	}

	@Override
	public void remove(int issue_code) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(issue_code);
	}

	@Override
	public List<Issue> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public int getTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Issue> searchlistAll(String search_keyword) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchlistAll(search_keyword);
	}

	

	

}
