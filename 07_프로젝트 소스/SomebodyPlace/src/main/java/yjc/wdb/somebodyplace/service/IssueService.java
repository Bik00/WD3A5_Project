package yjc.wdb.somebodyplace.service;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Issue;

public interface IssueService {
	public void regist(Issue b) throws Exception;
	public Issue read(int issue_code) throws Exception;
	public void modify(Issue b) throws Exception;
	public void remove(int issue_code) throws Exception;
	public List<Issue> listAll() throws Exception;
	public int getTotalCount() throws Exception;
	public List<Issue> searchlistAll(String search_keyword) throws Exception;
}
