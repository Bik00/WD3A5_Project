package yjc.wdb.somebodyplace.service;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Detail;
import yjc.wdb.somebodyplace.bean.Request;

public interface RequestService {
	
	public void insertRequest(int member_code) throws Exception;
	
	public List<Request> Requestlist(int request_code) throws Exception;
	
	public int readRequestCode(int a);
	
	public void insertRequestList(Request request);

	public void insertRequestOption(Request request);

	public int readRequestListCode(int request_code);

	public List<Request> readMyPlaceRequestList(int member_code);
	
}