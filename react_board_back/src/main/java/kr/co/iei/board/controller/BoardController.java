package kr.co.iei.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.iei.board.model.service.BoardService;

@CrossOrigin("*")
@RestController //컨트롤러의 모든 응답을 비동기로 처리 -> @ResponseBody
@RequestMapping(value = "/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "/list")
	public List test() {
		List list = boardService.selectBoardList(); 
		return list;
	}
}
