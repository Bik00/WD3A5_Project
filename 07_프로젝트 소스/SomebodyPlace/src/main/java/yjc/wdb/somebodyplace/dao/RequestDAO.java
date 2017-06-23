package yjc.wdb.somebodyplace.dao;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Detail;
import yjc.wdb.somebodyplace.bean.Request;

public interface RequestDAO {
	public void insertRequest(int member_code) throws Exception;
	
	public List<Request> Requestlist(int request_code) throws Exception;

	public void insertRequestList(Request request);

	public int readRequestCode(int a);

	public void insertRequestOption(Request request);

	public int readRequestListCode(int request_code);

	public List<Request> readMyPlaceRequestList(int member_code);

}
