package yjc.wdb.somebodyplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.somebodyplace.bean.Place;

@Repository
public class PlaceDAOImpl implements PlaceDAO {
	
	
	//BoardMapper.xml에 접근하기위해서 namespace를 멤버변수로 지정
	private static final String namespace = "yjc.wdb.placeMapper";				
	
	//root-context.xml 파일의 SqlSession Spring Bean에 지정한 sqlSession
	// 스프링빈은 객체를 생성하지 않고 프레임�p이 생성해줌(제어의 역전) >> 어노테이션지정(필수)
	@Inject
	private SqlSession sqlSession;	

	@Override
	public void create(Place vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".create", vo);
	}

	@Override
	public String read(String member_email) throws Exception {
		// TODO Auto-generated method stub
	
		 return sqlSession.selectOne(namespace + ".read",member_email);
	}

	@Override
	public void update(Place vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", bno);
	}

	@Override
	public List<Place> listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listAll");
	}

	@Override
	public String searchlogo(int member_code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchlogo",member_code);
	}

	@Override
	public int makechoice(int member_code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".makechoice",member_code);
	}

	@Override
	public String searchcategori1(int member_code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchcategori1",member_code);
	}

	@Override
	public String searchcategori2(int member_code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchcategori2",member_code);
	}

	@Override
	public int getPlaceCode(int member_code) throws Exception {
		return sqlSession.selectOne(namespace + ".getPlaceCode", member_code);
	}

	@Override
	public List<Place> MainPlacelist(int dcate_code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".MainPlacelist",dcate_code);
	}

}
