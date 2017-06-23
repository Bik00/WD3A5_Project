package yjc.wdb.somebodyplace.service;

import java.util.List;

import yjc.wdb.somebodyplace.bean.*;

public interface PlaceService {
	public void regist(Place b) throws Exception;
	public String read(String member_email) throws Exception;
	public String searchlogo(int member_code) throws Exception;
	public int makechoice(int member_code) throws Exception;
	public String searchcategori1(int member_code) throws Exception;
	public String searchcategori2(int member_code) throws Exception;
	public void modify(Place b) throws Exception;
	public void remove(int place_code) throws Exception;
	public List<Place> listAll() throws Exception;
	public List<Place> MainPlacelist(int dcate_code) throws Exception;
	public int getTotalCount() throws Exception;
	public int getPlaceCode(int member_code) throws Exception;
}
