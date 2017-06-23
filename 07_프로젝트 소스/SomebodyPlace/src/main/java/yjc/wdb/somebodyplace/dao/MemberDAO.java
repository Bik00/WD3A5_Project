package yjc.wdb.somebodyplace.dao;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Member;

public interface MemberDAO {
	// CRUD : Create, Read, Update, Delete 
	public void create(Member mem) throws Exception;
	public String read(int member_code) throws Exception;
	   public int read2(String member_email) throws Exception;
	public void update(Member mem) throws Exception;
	public void requestupdate(Member mem) throws Exception;
	public void delete(int member_code) throws Exception;
	public List<Member> listAll() throws Exception;
	public List<Member> login(Member member);
	public List<Member> listAll(double lat, double lng, int radius);
	public List<Member> orderlist(int member_code);
}