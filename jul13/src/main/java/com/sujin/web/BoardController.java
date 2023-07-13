package com.sujin.web;

// Ctrl + shift + o --> 임포트 정리해줘요.
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	//사용자가 /board라고 호출하면 동작할 매소드를 만들겠습니다.
	
	@GetMapping("/board")
	public String board() {
		
		return "board"; // jsp파일명
	}
	
}
