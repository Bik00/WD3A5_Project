package yjc.wdb.somebodyplace.service;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Option;

public interface OptionService {
	public void insert(Option option) throws Exception;
	public int selectOptionCode() throws Exception;
	public List<Option> selectOption(int product_code) throws Exception;
}
