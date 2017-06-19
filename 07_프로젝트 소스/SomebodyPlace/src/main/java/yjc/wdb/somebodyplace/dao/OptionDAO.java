package yjc.wdb.somebodyplace.dao;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Option;

public interface OptionDAO {
	public void insert(Option option) throws Exception;
	public int selectOptionCode() throws Exception;
	public List<Option> selectOption(int product_code) throws Exception;
}
