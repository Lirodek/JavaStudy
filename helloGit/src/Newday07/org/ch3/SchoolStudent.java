package Newday07.org.ch3;
import static java.lang.System.out;
public class SchoolStudent {
	String student;
	double avg;
	public SchoolStudent(String student, double avg){
		this.student = student ;
		this.avg = avg;
	}
	public void SchoolPrint () {
		out.println("\n"+student+"���� ��� ������ "+avg+"�Դϴ�. \n");
	}
}
