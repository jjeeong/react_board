package kr.co.iei.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.iei.board.model.dto.BoardDTO;
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
	
	@GetMapping(value = "/view/{boardNo}")
	public BoardDTO view(@PathVariable int boardNo) {
		BoardDTO board = boardService.selectOneBoard(boardNo);
		return board;
	}
	
	@PostMapping(value = "/insert")
	public int insert(@RequestBody BoardDTO board) {
		int result = boardService.insertBoard(board); 
		return result;
	}
	
	@GetMapping(value = "/delete/{boardNo}")
	public int delete(@PathVariable int boardNo) {
		int result = boardService.deleteBoard(boardNo);
		return result;
	}
	
	@PostMapping(value = "/modify")
	public int modify(@RequestBody BoardDTO board) {
		int result = boardService.updateBoard(board);
		return result;
	}
}
