package yjc.wdb.somebodyplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.somebodyplace.bean.Dcate;
import yjc.wdb.somebodyplace.bean.Mcate;

@Repository
public class CateDAOImpl implements CateDAO {

	@Inject
	private SqlSession sql;
	private static final String namespace = "yjc.wdb.somebodyplace.CateMapper";
	
	@Override
	public List<Mcate> McateList() throws Exception {
		return sql.selectList(namespace + ".mcateList");
	}

	@Override
	public List<Dcate> DcateList() throws Exception {
		return sql.selectList(namespace + ".dcateList");
	}

}
