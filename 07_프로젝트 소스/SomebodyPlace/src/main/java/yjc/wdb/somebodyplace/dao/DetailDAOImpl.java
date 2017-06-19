package yjc.wdb.somebodyplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.somebodyplace.bean.Detail;

@Repository
public class DetailDAOImpl implements DetailDAO {

   @Inject
   private SqlSession sql;
   private static final String NAMESPACE = "yjc.wdb.somebodyplace.DetailMapper";
   
   @Override
   public void insert(Detail detail) throws Exception {
      sql.insert(NAMESPACE + ".insertDetail", detail);
   }

   @Override
   public List<Detail> selectDetail(int option_code) throws Exception {
      return sql.selectList(NAMESPACE + ".selectDetail", option_code);
   }

}