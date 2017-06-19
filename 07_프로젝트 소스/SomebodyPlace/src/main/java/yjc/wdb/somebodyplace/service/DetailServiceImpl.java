package yjc.wdb.somebodyplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import yjc.wdb.somebodyplace.bean.Detail;
import yjc.wdb.somebodyplace.dao.DetailDAO;

@Service
public class DetailServiceImpl implements DetailService {

   @Inject
   private DetailDAO dao;
   
   @Override
   public void insert(Detail detail) throws Exception {
      dao.insert(detail);
   }

   @Override
   public List<Detail> selectDetail(int option_code) throws Exception {
      return dao.selectDetail(option_code);
   }

}