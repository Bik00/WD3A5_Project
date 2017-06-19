package yjc.wdb.somebodyplace.service;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Detail;

public interface DetailService {
   public void insert(Detail detail) throws Exception;
   public List<Detail> selectDetail(int option_code) throws Exception;
}