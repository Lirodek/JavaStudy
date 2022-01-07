package GenericDemo;
class StudentInfo{
	public int grade;
	StudentInfo(int grade){
		this.grade = grade;
	}
}
class EmployeeInfo{
	public int rank;
	EmployeeInfo(int rank){
		this.rank = rank;
	}
}
class Person<T, S>{
	 public T info;
	 public S id;
	 Person(T info){
		 this.info = info;
	 }
}

public class GenericMain {

	public static void main(String[] args) {
//		Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(new EmployeeInfo(1),1);
	}

}
