package yjc.wdb.somebodyplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.somebodyplace.bean.Detail;
import yjc.wdb.somebodyplace.bean.Request;
@Repository
public class RequestDAOImpl implements RequestDAO {
	
	@Inject
	private SqlSession sql;
	private static final String NAMESPACE = "yjc.wdb.somebodyplace.RequestMapper";

	@Override
	public void insertRequest(int member_code) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(NAMESPACE + ".insertRequest",member_code);
	}

	@Override
	public List<Request> Requestlist(int request_code) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(NAMESPACE + ".Requestlist", request_code);
	}

	@Override
	public void insertRequestList(Request request) {
		// TODO Auto-generated method stub
		sql.insert(NAMESPACE+".insertRequestList", request);
	}

	@Override
	public int readRequestCode(int a) {
		// TODO Auto-generated method stub
		return sql.selectOne(NAMESPACE+".readRequestCode", a);
	}

	@Override
	public void insertRequestOption(Request request) {
		// TODO Auto-generated method stub
		sql.insert(NAMESPACE+".insertRequestOption", request);
	}

	@Override
	public int readRequestListCode(int request_code) {
		// TODO Auto-generated method stub
		return sql.selectOne(NAMESPACE+".readRequestListCode", request_code);
	}

	@Override
	public List<Request> readMyPlaceRequestList(int member_code) {
		// TODO Auto-generated method stub
		return sql.selectList(NAMESPACE+".readMyPlaceRequestList", member_code);
	}
}
