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
	
	public Map<String, BoardDTO> findAll(){
		return boardMap;
	}
	
	public BoardDTO findById(String bno) {
		for(String key: boardMap.keySet()) {
			if(bno.equals(boardMap.get(key).getBno())) {
				return boardMap.get(key);
			}
		}
		return null;
	}
	
	public boolean update(BoardDTO boardDTO, String bno) {
		for(String key: boardMap.keySet()) {
			if(bno.equals(boardMap.get(key).getBno())) {
				boardMap.get(key).setTitle(boardDTO.getTitle());
				boardMap.get(key).setWriter(boardDTO.getWriter());
				return true;
			}
		}
		return false;
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

	public List<BoardDTO> search(String q) {
		// 검색결과를 담을 리스트
		List<BoardDTO> searchList = new ArrayList<>();
		for(String key: boardMap.keySet()) {
			if(q.equals(boardMap.get(key).getWriter())) {
//				searchList.add(boardMap.get(key));
				
				BoardDTO result = boardMap.get(key);
				searchList.add(result);
			}
		}
		return searchList;
	}
	
	
	
	
	
	
}










