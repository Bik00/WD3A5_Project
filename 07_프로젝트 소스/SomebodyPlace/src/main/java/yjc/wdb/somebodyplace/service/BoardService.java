package yjc.wdb.somebodyplace.service;

import java.util.List;

import yjc.wdb.somebodyplace.bean.Board;

public interface BoardService {
	public void insertInit(Board board) throws Exception;
	public List<Board> selectBoardList(int place_code) throws Exception;
	public void insertBoard(Board board) throws Exception;
	public void updateBoard(Board board) throws Exception;
	public void deleteBoard(int del_code) throws Exception;
}
