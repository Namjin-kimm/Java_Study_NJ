package com.iu.start.board.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class QnaService implements BoardService{
	@Autowired
	private QnaDAO qnaDAO;
	
	public int setReply(QnaDTO qnaDTO)throws Exception{
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1);
		qnaDTO.setDepth(parent.getDepth() + 1);
		
		qnaDAO.setStepUpdate(parent);
		int result = qnaDAO.setReplyAdd(qnaDTO);
		return result;
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.getRowNum();
		Long totalCount = qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		
//		Long perPage = 10L; //한 페이지에 출력할 목록의 갯수
//		page		startRow		lastRow
//		1			1				5
//		2			6				10
//		3			11				15
		
//		Long startRow = (page - 1)*perPage + 1;
//		Long lastRow = page*perPage;
//		
//		System.out.println("StartRow : " + startRow);
//		System.out.println("LastRow : " + lastRow);
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		System.out.println("Insert 전 : " + boardDTO.getNum());
		int result = qnaDAO.setAdd(boardDTO);
		System.out.println("Insert  : " + boardDTO.getNum());
		return result;
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
