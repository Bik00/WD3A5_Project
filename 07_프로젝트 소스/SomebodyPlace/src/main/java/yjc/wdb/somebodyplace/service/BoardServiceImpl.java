package yjc.wdb.somebodyplace.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import yjc.wdb.somebodyplace.bean.Board;
import yjc.wdb.somebodyplace.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public void insertInit(Board board) throws Exception {
		dao.insertInit(board);
	}

	@Override
	public List<Board> selectBoardList(int place_code) throws Exception {
		return dao.selectBoardList(place_code);
	}

	@Override
	public void insertBoard(Board board) throws Exception {
		dao.insertBoard(board);
	}

	@Override
	public void updateBoard(Board board) throws Exception {
		dao.updateBoard(board);
	}

	@Override
	public void deleteBoard(int del_code) throws Exception {
		dao.deleteBoard(del_code);
	}

}
