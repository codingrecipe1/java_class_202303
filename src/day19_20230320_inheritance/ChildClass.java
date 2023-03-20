package day19_20230320_inheritance;

public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("자식 클래스 생성자");
	}
	
	// hello 재정의
	@Override
	public void hello() {
		System.out.println("자식 hello");		
	}
	
//	@Override
//	public void hi() {
//		System.out.println("자식 hi");
//	}
	
	
}







