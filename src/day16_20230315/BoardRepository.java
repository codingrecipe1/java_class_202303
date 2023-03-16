package day16_20230315;

import java.util.*;

public class BoardRepository {
//	private List<BoardDTO> list = new ArrayList<>();
	private Map<String, BoardDTO> boardMap = new HashMap<>();

	public boolean save(BoardDTO boardDTO) {
		BoardDTO result = boardMap.put(boardDTO.getBno(), boardDTO);
		if(result == null) {
			return true;
		} else {
			return false;			
		}
	}

	public Map<String, BoardDTO> findAll() {
		return boardMap;
	}

	public BoardDTO findById(String bno) {
		/*
		 * map 반복문 돌리고 
		 * bno와 일치하는 객체를 찾고 
		 * 찾으면 리턴 
		 */
		for(String key: boardMap.keySet()) {
			if(bno.equals(boardMap.get(key).getBno())) {
				return boardMap.get(key);
			}
		}
		return null;
	}

	public boolean updateNew(String bno, String updateTitle, String updateWriter) {
		for(String key: boardMap.keySet()) {
			if(bno.equals(boardMap.get(key).getBno())) {
				boardMap.get(key).setTitle(updateTitle);
				boardMap.get(key).setWriter(updateWriter);
				return true;
			}
		}
		return false;
	}

	public boolean delete(String bno) {
		for(String key: boardMap.keySet()) {
			if(bno.equals(boardMap.get(key).getBno())) {
				boardMap.remove(key);
				return true;
			}
		}
		return false;
	}
	

	
	
	
	
}







