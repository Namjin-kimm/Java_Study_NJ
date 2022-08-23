package com.iu.start.board.noticeDAOTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.notice.NoticeDAO;
import com.iu.start.board.notice.NoticeDTO;

public class NoticeDAOTest extends MyAbstractTest{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void setAdd() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
//		NoticeDTO noticeDTO = new NoticeDTO();
		boardDTO.setTitle("KK");
		boardDTO.setWriter("KNJ");
		boardDTO.setContents("kkkkkk");
		int result = noticeDAO.setAdd(boardDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void getListTest() throws Exception {
		List<BoardDTO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
//	@Test
	public void getDetailTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
//		NoticeDTO noticeDTO = new NoticeDTO();
		boardDTO.setNum(1L);
		boardDTO = (NoticeDTO) noticeDAO.getDetail(boardDTO);
		assertNotNull(boardDTO);
	}
	
//	@Test
	public void setUpdate() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
//		NoticeDTO noticeDTO = new NoticeDTO();
		boardDTO.setNum(1L);
		boardDTO.setTitle("hahaha");
		boardDTO.setContents("hahahahaha");
		int result = noticeDAO.setUpdate(boardDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void setDelete() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
//		NoticeDTO noticeDTO = new NoticeDTO();
		boardDTO.setNum(1L);
		int result = noticeDAO.setDelete(boardDTO);
		assertEquals(1, result);
	}

}
