package yjc.wdb.somebodyplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.somebodyplace.bean.Option;

@Repository
public class OptionDAOImpl implements OptionDAO {

	@Inject
	private SqlSession sql;
	private static final String NAMESPACE = "yjc.wdb.somebodyplace.OptionMapper";
	
	@Override
	public void insert(Option option) throws Exception {
		sql.insert(NAMESPACE + ".insertOption", option);
	}

	@Override
	public int selectOptionCode() throws Exception {
		return sql.selectOne(NAMESPACE + ".selectOptionCode");
	}

	@Override
	public List<Option> selectOption(int product_code) throws Exception {
		return sql.selectList(NAMESPACE + ".selectOption", product_code);
	}

}
