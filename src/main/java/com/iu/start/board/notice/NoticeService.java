package com.iu.start.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
//		System.out.println("Service Page : " + page);
//		Long perPage = 10L; //한 페이지에 출력할 목록의 갯수
////		page		startRow		lastRow
////		1			1				10
////		2			11				20
////		3			21				30
//		
//		Long startRow = (page - 1)*perPage + 1;
//		Long lastRow = page*perPage;
//		
//		System.out.println("StartRow : " + startRow);
//		System.out.println("LastRow : " + lastRow);
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		
////		JSP에 페이지번호를 출력 1 - ?
////		 1. 글의 총 갯수
//		Long totalCount = noticeDAO.getCount();
//		
////		 2. 글의 총 갯수를 이용해서 총 페이지 수 구하기
//		 Long totalPage = totalCount/perPage;
//		if(totalCount%perPage != 0) {
////			totalPage += 1;
//			totalPage++;
//		}
//		
////		3. 글의 총 페이지 수로 totalBlock 갯수 구하기
////		Block	 : 
////		perBlock : 한 페이지에 출력할 번호의 수
//		
//		long perBlock = 5L;
//		long totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock != 0) {
//			totalBlock++;
//		}
//		
////		4. page로 현재 Block 번호 찾기
////		page		curBlock
////		1			1
////		2			1
////		3			1
////		4			1
////		5			1
////		6			2
////		7			2
//		
//		Long curBlock = page/perBlock;
//		if(page%perBlock !=0) {
//			curBlock++;
//		}
//		
////		5. curBlock으로 시작번호와 끝번호 알아 오기
////		curBlock	startNum	latNum
////		1			1			5
////		2			6			10
////		3			11			15
//		
//		Long startNum = (curBlock - 1)*perBlock + 1;
//		Long lastNum = curBlock*perBlock; 
//		
//		System.out.println("TotalPage : " + totalPage);
//		System.out.println("TotalBlock : " + totalBlock);
//		System.out.println("curBlock : " + curBlock);
//		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.setAdd(boardDTO);
	}
	
//	오버로딩
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
			
			String realpath = servletContext.getRealPath("/resources/upload/notice");
			
			
			for(int i = 0; i < files.length; i++) {
				File file = new File(realpath);
				if(files[i].isEmpty()) {
	
					if(file.exists()) {
						file.mkdirs();
					}
					String fileName = UUID.randomUUID().toString();
					fileName = fileName + "_" + files[i].getOriginalFilename();
					file = new File(file, fileName);
					files[i].transferTo(file);
				}		
	
			}
			return 0; 
			//noticeDAO.setAdd(boardDTO);
		}
	

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
	
	

}
