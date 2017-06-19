package yjc.wdb.somebodyplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import yjc.wdb.somebodyplace.bean.Dcate;
import yjc.wdb.somebodyplace.bean.Mcate;
import yjc.wdb.somebodyplace.dao.CateDAO;


@Service
public class CateServiceImpl implements CateService{

	@Inject
	private CateDAO dao;
	
	@Override
	public List<Mcate> McateList() throws Exception {
		return dao.McateList();
	}

	@Override
	public List<Dcate> DcateList() throws Exception {
		return dao.DcateList();
	}

}
