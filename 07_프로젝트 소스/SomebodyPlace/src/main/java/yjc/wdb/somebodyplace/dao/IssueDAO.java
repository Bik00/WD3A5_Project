package yjc.wdb.somebodyplace.dao;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Issue;


public interface IssueDAO {
	public void create(Issue vo) throws Exception;
	public Issue read(int issue_code) throws Exception;
	public void update(Issue vo) throws Exception;
	public void delete(int issue_code) throws Exception;
	public List<Issue> listAll() throws Exception;
	public List<Issue> searchlistAll(String search_keyword) throws Exception;
}
