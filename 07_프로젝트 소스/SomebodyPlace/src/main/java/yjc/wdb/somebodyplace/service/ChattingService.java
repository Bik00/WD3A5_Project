package yjc.wdb.somebodyplace.service;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Auto;
import yjc.wdb.somebodyplace.bean.Chatting;
import yjc.wdb.somebodyplace.bean.Member;

public interface ChattingService {
	
	public void registChat(Chatting chatting) throws Exception;

	public List<Member> getReceiver(Member member);

	public List<Chatting> getRooms(Chatting chatting);

	public List<Chatting> chatList(Chatting chatting);

	public int getSenderNum(Chatting chatting);

	public void addDist(Chatting chatting);

	public void readDist(Chatting chatting);

	public int countDist(Chatting chatting);

	public int countChatsInRoom(Chatting chatting);

	public void addAutoList(Auto auto);

	public void delAutoList(Auto auto);

	public List<Auto> readAutoList(Auto auto);

	public void addAuto(Auto auto);

	public List<Auto> readAuto(Auto auto);

	public void delChat(Chatting chatting);

	public String getReceiverName(Chatting chatting);
	
}