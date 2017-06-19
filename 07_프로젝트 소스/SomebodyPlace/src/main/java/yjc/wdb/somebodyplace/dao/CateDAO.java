package yjc.wdb.somebodyplace.dao;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Dcate;
import yjc.wdb.somebodyplace.bean.Mcate;

public interface CateDAO {
	public List<Mcate> McateList() throws Exception;
	public List<Dcate> DcateList() throws Exception;
}
