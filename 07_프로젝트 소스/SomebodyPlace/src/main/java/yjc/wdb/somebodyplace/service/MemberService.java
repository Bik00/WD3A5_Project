package yjc.wdb.somebodyplace.service;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Member;

public interface MemberService {
	public void regist(Member m) throws Exception;
	public String read(int member_code) throws Exception;
	public int read2(String member_email) throws Exception;
	public void modify(Member m) throws Exception;
	public void requestupdate(Member mem) throws Exception;
	public void remove(int member_code) throws Exception;
	public List<Member> listAll() throws Exception;
	public List<Member> login(Member member);
	public List<Member> listAll(double Lat, double Lng, int Radius) throws Exception;
	public List<Member> orderlist(int member_code) throws Exception;
}
