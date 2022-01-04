package day15.ch07.ex09;

import java.util.Vector;

interface IStack<T>{
	T pop();
	boolean push(T ob);
}
class MyStack<T> implements IStack{
	Vector<T> v;
	private int size=0;
	public MyStack() {
		v= new Vector<T>();
		size=-1;
	}
	public T pop() {
		if(size==-1) {
			return null;
		}
		return v.get(size--);
	}

	@Override
	public boolean push(Object ob) {
		// TODO Auto-generated method stub
		v.add((T) ob);
		size++;
		return false;
	}
	
}
public class Ex09 {
	
	public static void main(String[] args) {
		IStack<Integer> stack = new MyStack<Integer>();
		for(int i=0;i<10;i++) {
			stack.push(i);
		}
		while(true) {
			Integer n = stack.pop();
			if(n==null) break;
			System.out.print(n+" ");
		}
		
	}

}

