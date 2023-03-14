package day15_20230314;

import java.util.*;

public class MapExample {

	public static void main(String[] args) {
		Map<Integer, String> map1 = new HashMap<>();
		List<String> list1 = new ArrayList<>();
		
		map1.put(1, "안녕하세요");
		System.out.println(map1.put(2, "hello")); // null
		System.out.println(map1.put(2, "안녕하세요")); // hello
		System.out.println(map1.get(2));
		
		String val1 = map1.get(1);
		System.out.println(val1);
		
//		map1.remove(2);
		System.out.println(map1.get(2));
		
		for(int key: map1.keySet()) {
			System.out.println(key);
			System.out.println(map1.get(key));
		}		

	}

}
