package org.NewDay09.Project;
import static java.lang.System.out;
class Person{}
class Student extends Person{}
class Researcher extends Person{}
class Professor extends Researcher{}
public class ch04Ex06 {
	static void print(Person p ) {
		int i=1;
		if(p instanceof Person)out.print(" Person "+i++);
		if(p instanceof Student)out.print(" Student "+i++);
		if(p instanceof Researcher)out.print(" Researcher "+i++);
		if(p instanceof Professor)out.print(" Professor "+i++);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.print("new Student() -> \t");print(new Student());
		out.print("\nnew Researcher() -> \t");print(new Researcher());
		out.print("\nnew Professor() -> \t");print(new Professor());
	}

}
