package yjc.wdb.somebodyplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import yjc.wdb.somebodyplace.bean.Auto;
import yjc.wdb.somebodyplace.bean.Chatting;
import yjc.wdb.somebodyplace.bean.Member;
import yjc.wdb.somebodyplace.dao.ChattingDAO;
import yjc.wdb.somebodyplace.dao.MemberDAO;

@Service
public class ChattingServiceImpl implements ChattingService {

	@Inject
	private ChattingDAO dao;
	
	@Override
	public void registChat(Chatting chatting) throws Exception {
		// TODO Auto-generated method stub
		
		dao.registChat(chatting);
	}
	
	@Override
	public void delChat(Chatting chatting) {
		// TODO Auto-generated method stub
		dao.delChat(chatting);
	}
	
	@Override
	public List<Member> getReceiver(Member member) {
		// TODO Auto-generated method stub
		return dao.getReceiver(member);
	}

	@Override
	public List<Chatting> getRooms(Chatting chatting) {
		// TODO Auto-generated method stub
		return dao.getRooms(chatting);
	}

	@Override
	public List<Chatting> chatList(Chatting chatting) {
		// TODO Auto-generated method stub
		return dao.chatList(chatting);
	}

	@Override
	public int getSenderNum(Chatting chatting) {
		// TODO Auto-generated method stub
		return dao.getSenderNum(chatting);
	}

	@Override
	public void addDist(Chatting chatting) {
		// TODO Auto-generated method stub
		dao.addDist(chatting);
	}

	@Override
	public void readDist(Chatting chatting) {
		// TODO Auto-generated method stub
		dao.readDist(chatting);
	}

	@Override
	public int countDist(Chatting chatting) {
		// TODO Auto-generated method stub
		return dao.countDist(chatting);
	}

	@Override
	public int countChatsInRoom(Chatting chatting) {
		// TODO Auto-generated method stub
		return dao.countChatsInRoom(chatting);
	}

	@Override
	public void addAutoList(Auto auto) {
		// TODO Auto-generated method stub
		dao.addAutoList(auto);
	}

	@Override
	public void delAutoList(Auto auto) {
		// TODO Auto-generated method stub
		dao.delAutoList(auto);
	}

	@Override
	public List<Auto> readAutoList(Auto auto) {
		// TODO Auto-generated method stub
		return dao.readAutoList(auto);
	}

	@Override
	public void addAuto(Auto auto) {
		// TODO Auto-generated method stub
		dao.addAuto(auto);
	}

	@Override
	public List<Auto> readAuto(Auto auto) {
		// TODO Auto-generated method stub
		return dao.readAuto(auto);
	}

	@Override
	public String getReceiverName(Chatting chatting) {
		// TODO Auto-generated method stub
		return dao.getReceiverName(chatting);
	}



}
