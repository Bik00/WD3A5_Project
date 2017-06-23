package yjc.wdb.somebodyplace.dao;

import java.util.List;

import yjc.wdb.somebodyplace.bean.*;

public interface PlaceDAO {
	public void create(Place vo) throws Exception;
	public String read(String member_email) throws Exception;
	public String searchlogo(int member_code) throws Exception;
	public int makechoice(int member_code) throws Exception;
	public String searchcategori1(int member_code) throws Exception;
	public String searchcategori2(int member_code) throws Exception;
	public void update(Place vo) throws Exception;
	public void delete(int bno) throws Exception;
	public List<Place> listAll() throws Exception;
	public List<Place> MainPlacelist(int dcate_code) throws Exception;
	public int getPlaceCode(int member_code) throws Exception;
}
