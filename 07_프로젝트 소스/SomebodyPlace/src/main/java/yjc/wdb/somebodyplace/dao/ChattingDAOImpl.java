package yjc.wdb.somebodyplace.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yjc.wdb.somebodyplace.bean.Auto;
import yjc.wdb.somebodyplace.bean.Chatting;
import yjc.wdb.somebodyplace.bean.Member;

@Repository
public class ChattingDAOImpl implements ChattingDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace ="Chatting";
	private static String namespace2 = "yjc.wdb.memberMapper";
	
	@Override
	public void registChat(Chatting chatting) throws Exception {
		session.update(namespace+".addChat", chatting);
	}

	@Override
	public void delChat(Chatting chatting) {
		session.delete(namespace+".delChat", chatting);
	}
	
	@Override
	public List<Member> getReceiver(Member member) {
		// TODO Auto-generated method stub
		return session.selectList(namespace2+".getReceiver", member);
	}

	@Override
	public List<Chatting> getRooms(Chatting chatting) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getRooms", chatting);
	}

	@Override
	public List<Chatting> chatList(Chatting chatting) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".chatList", chatting);
	}

	@Override
	public int getSenderNum(Chatting chatting) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getSenderNum", chatting);
	}

	@Override
	public void addDist(Chatting chatting) {
		// TODO Auto-generated method stub
		session.update(namespace+".addDist", chatting);
	}

	@Override
	public void readDist(Chatting chatting) {
		// TODO Auto-generated method stub
		session.update(namespace+".readDist", chatting);
	}

	@Override
	public int countDist(Chatting chatting) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".countDist", chatting);
	}

	@Override
	public int countChatsInRoom(Chatting chatting) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".countChatsInRoom", chatting);
	}

	@Override
	public void addAutoList(Auto auto) {
		// TODO Auto-generated method stub
		session.update(namespace+".addAutoList", auto);
	}

	@Override
	public void delAutoList(Auto auto) {
		// TODO Auto-generated method stub
		session.delete(namespace+".delAutoList", auto);
	}

	@Override
	public List<Auto> readAutoList(Auto auto) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".readAutoList", auto);
	}

	@Override
	public void addAuto(Auto auto) {
		// TODO Auto-generated method stub
		session.update(namespace+".addAuto", auto);
	}

	@Override
	public List<Auto> readAuto(Auto auto) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".readAuto", auto);
	}

	@Override
	public String getReceiverName(Chatting chatting) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getReceiverName", chatting);
	}

}