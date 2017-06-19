package yjc.wdb.somebodyplace.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.somebodyplace.bean.Issue;


@Repository
public class IssueDAOImpl implements IssueDAO {
	
	//BoardMapper.xml에 접근하기위해서 namespace를 멤버변수로 지정
	private static final String namespace = "yjc.wdb.issueMapper";				
	
	//root-context.xml 파일의 SqlSession Spring Bean에 지정한 sqlSession
	// 스프링빈은 객체를 생성하지 않고 프레임웤이 생성해줌(제어의 역전) >> 어노테이션지정(필수)
	@Inject
	private SqlSession sqlSession;	

	@Override
	public void create(Issue vo) throws Exception {
		sqlSession.insert(namespace + ".create", vo);
		
	}

	@Override
	public Issue read(int issue_code) throws Exception {
		// TODO Auto-generated method stub
		 return sqlSession.selectOne(namespace + ".read", issue_code);
	}

	@Override
	public void update(Issue vo) throws Exception {
		sqlSession.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(int issue_code) throws Exception {
		
		sqlSession.delete(namespace + ".delete", issue_code);
		
	}

	@Override
	public List<Issue> listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listAll");
	}

	@Override
	public List<Issue> searchlistAll(String search_keyword) throws Exception {
		// TODO Auto-generated method stub
	
			System.out.print(search_keyword);
		
		
		   return sqlSession.selectList(namespace + ".searchlistAll",search_keyword);
	}
	
	
	

}
