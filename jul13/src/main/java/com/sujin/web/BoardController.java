package com.sujin.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// Ctrl + shift + o --> 임포트 정리해줘요.
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	// 서비스와 연결하기
	@Autowired
	private BoardSerivce boardService;
	
	//사용자가 /board라고 호출하면 동작할 매소드를 만들겠습니다.
	@GetMapping("/board")
	public ModelAndView board() {
		ModelAndView mv = new ModelAndView("board"); // jsp파일명
		
		//서비스에게 일 시킵니다.
		List<BoardDTO> list = boardService.boardList();
		
		mv.addObject("list", list);
		
		return mv;
	}
	
	@GetMapping("/board2")
	public String board2(Model model) {
		model.addAttribute("name", "홍길동");
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		for (int i = 1; i < 11; i++) {
			BoardDTO dto = new BoardDTO(i, "제목입니다.", "홍길동", "2023-07-13", i);
			list.add(dto);
		}
		
		model.addAttribute("list", list);
		
		return "board2";
	}
	
}
