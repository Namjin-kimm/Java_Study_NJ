package com.iu.home.board.notice;

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
	
//	@Test
	public void setAdd() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("KK");
		noticeDTO.setWriter("KNJ");
		noticeDTO.setContents("kkkkkk");
		noticeDTO.setHit(1L);
		int result = noticeDAO.setAdd(noticeDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void getListTest() throws Exception {
		List<BoardDTO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getDetailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		noticeDTO = (NoticeDTO) noticeDAO.getDetail(noticeDTO);
		assertNotNull(noticeDTO);
	}

}
