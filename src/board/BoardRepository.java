package board;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
	private List<BoardDTO> list = new ArrayList<>();
	
	/*
	 * 리턴타입:
	 * 메서드이름:
	 * 매개변수: 
	 */
	public boolean save(BoardDTO boardDTO) {
		System.out.println("BoardRepository.save()" + boardDTO);
		boolean a = list.add(boardDTO); 
		return a;
	}
	
	public List<BoardDTO> findAll(){
		return list;
	}
	
	public BoardDTO findById(String bno) {
		for(BoardDTO b : list) {
			if(b.getBno().equals(bno)) {
				return b;
			}
		}
		return null;
	}
	
	public boolean update(BoardDTO boardDTO, String bno) {
		for(BoardDTO b : list) {
			if(b.getBno().equals(bno)) {
				b.setTitle(boardDTO.getTitle());
				b.setWriter(boardDTO.getWriter());
				return true;
			}
		}
		return false;
	}
	
	public boolean updateNew(String bno, String updateTitle, String updateWriter) {
		for(BoardDTO b : list) {
			if(b.getBno().equals(bno)) {
				b.setTitle(updateTitle);
				b.setWriter(updateWriter);
				return true;
			}
		}
		return false;
	}
		
	public boolean delete(String bno) {
		for(BoardDTO b : list) {
			if(b.getBno().equals(bno)) {
				list.remove(b);
				return true;
			}
		}
		return false;
	}


	
	
	
	
	
}
