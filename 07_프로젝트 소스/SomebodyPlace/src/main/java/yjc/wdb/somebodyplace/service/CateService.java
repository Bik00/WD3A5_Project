package yjc.wdb.somebodyplace.service;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Dcate;
import yjc.wdb.somebodyplace.bean.Mcate;

public interface CateService {
	public List<Mcate> McateList() throws Exception;
	public List<Dcate> DcateList() throws Exception;
}
