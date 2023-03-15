package day15_20230314;

import java.util.*;

public class StudentMain {

	public static void main(String[] args) {
		String str1 = new String();
		// 학생정보를 관리할 Map
		Map<Long, StudentDTO> studentMap = new HashMap<>();
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentNumber("1111");
		studentDTO.setStudentName("김자바");
		studentDTO.setStudentMajor("컴퓨터공학");
		studentDTO.setStudentMobile("010-1111-1111");
		
		StudentDTO studentDTO2 = new StudentDTO();
		studentDTO2.setId(1L);
		studentDTO2.setStudentNumber("1111");
		studentDTO2.setStudentName("김자바");
		studentDTO2.setStudentMajor("컴퓨터공학");
		studentDTO2.setStudentMobile("010-1111-1111");
		
		System.out.println(studentDTO.equals(studentDTO2));
		System.out.println(studentDTO.getId().equals(studentDTO2.getId()));
		
		studentMap.put(studentDTO.getId(), studentDTO);
		
		StudentDTO studentDTO1 = new StudentDTO();
		studentDTO1.setId(2L);
		studentDTO1.setStudentNumber("2222");
		studentDTO1.setStudentName("이자바");
		studentDTO1.setStudentMajor("경영학");
		studentDTO1.setStudentMobile("010-2222-2222");
		
		studentMap.put(studentDTO1.getId(), studentDTO1);
		
		// 반복문으로 출력 
		for(Long id: studentMap.keySet()) {
			System.out.println(id);
			System.out.println(studentMap.get(id)); // student 객체
			// 학생의 이름만 
			System.out.println(studentMap.get(id).getStudentName());
		}

	}

}






