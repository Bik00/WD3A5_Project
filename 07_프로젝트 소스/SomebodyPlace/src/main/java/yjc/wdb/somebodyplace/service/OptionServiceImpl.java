package yjc.wdb.somebodyplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import yjc.wdb.somebodyplace.bean.Option;
import yjc.wdb.somebodyplace.dao.OptionDAO;

@Service
public class OptionServiceImpl implements OptionService {

	@Inject
	private OptionDAO dao;
	
	@Override
	public void insert(Option option) throws Exception {
		dao.insert(option);
	}

	@Override
	public int selectOptionCode() throws Exception {
		return dao.selectOptionCode();
	}

	@Override
	public List<Option> selectOption(int product_code) throws Exception {
		return dao.selectOption(product_code);
	}

}
