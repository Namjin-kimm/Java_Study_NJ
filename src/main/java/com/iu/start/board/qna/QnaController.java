package com.iu.start.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "QnA";
	}

	@RequestMapping(value = "list.iu")
	public ModelAndView getList(Long page) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(page);
		mv.addObject("list", ar);
//		mv.addObject("board", "QnA");
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping(value = "detail.iu")
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
//		mv.addObject("board", "QnA");
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping(value = "add.iu")
	public ModelAndView setAdd() throws Exception {
		ModelAndView mv = new ModelAndView();
//		mv.addObject("board", "QnA");
		mv.setViewName("board/add");
		return mv;
	}
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setAdd(boardDTO);
		return "redirect:list.iu";
	}
	
	@RequestMapping(value = "update.iu")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		boardDTO = qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
//		mv.addObject("board", "QnA");
		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setUpdate(boardDTO);
		return "redirect:detail.iu?num=" + boardDTO.getNum();
	}
	
	@RequestMapping(value = "delete.iu")
	public String setDelete(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setDelete(boardDTO);
		return "redirect:list.iu";
	}
}
