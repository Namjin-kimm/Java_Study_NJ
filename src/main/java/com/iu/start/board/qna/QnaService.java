package com.iu.start.board.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;

@Service
public class QnaService implements BoardService{
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> getList(Long page) throws Exception {
		Long perPage = 10L; //한 페이지에 출력할 목록의 갯수
//		page		startRow		lastRow
//		1			1				5
//		2			6				10
//		3			11				15
		
		Long startRow = (page - 1)*perPage + 1;
		Long lastRow = page*perPage;
		
		System.out.println("StartRow : " + startRow);
		System.out.println("LastRow : " + lastRow);
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		return qnaDAO.getList(map);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}
	
	

}
