package Mini.Project.Day7;

import java.util.Scanner;

import static java.lang.System.out;

class Student {
	public int no; // ��ȣ
	public String name; // �̸�
	public int kor, eng, mat ;
	public int sum; // �������� ����
	public double avg,wait; // ������ ������ ���
	public String grade; // ����
	public int rank; // ���
	
	public Student(int no) {
	}

	public Student(int no, String name, int kor, int eng, int mat) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		sum = kor+eng+mat;
		avg = (double)sum /3;
		wait = avg*100;
		avg = (int)wait /100;
		getGrade();
		
		// ����, ���, ������ ������ش�.
		
	}

	public void getGrade() {
		if(avg>90) grade = "A";
		else if(avg>80) grade = "B";
		else if(avg>70) grade = "C";
		else if(avg>60) grade = "D";
		else grade = "����";
	}
	// ��ü�� ����ϸ� toString()�� �ڵ� ȣ�� �ȴ�.
	public void studentPrint() {
		out.println(no + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t"
				+ sum + "\t"+ avg +"\t"+  grade + "\t" + rank);
	}
	@Override
	public String toString() {
		return no + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t"
				+ sum + "\t"+ avg +"\t"+  grade + "\t" + rank;
	}
}
// Student st1 = new Student();
// st1.name = "ȫ�浿"
// Student st2 = new Student(1, "��浿", 60, 70, 80);

public class MainCls {
	public static final Scanner scan = new Scanner(System.in);
	public static final Scanner scanN = new Scanner(System.in);
	
	public static final int MAX = 100;
	static Student[] sArr = new Student[MAX];
	static int top = 0; // ���� �ڷᱸ��ó��.
	public static int sequence = 1;
	
	
	// static �ʱ�ȭ ��
	static {
		sArr[top++] = new Student(sequence++, "�豤��", 60, 60, 75);
		sArr[top++] = new Student(sequence++, "������", 90, 80, 80);
		sArr[top++] = new Student(sequence++, "������", 90, 100, 95);	
		appointedRank();
		rankCheck();
	}
	public static void appointedRank() {
		int temp=99;
		for(int i = 1; i < top; i++) {
			for(int j = 0; j < top - i; j++) {
				if(sArr[j].avg < sArr[j+1].avg) {
					sArr[temp] = sArr[j];
					sArr[j] = sArr[j+1];
					sArr[j+1]=sArr[temp];
				}
			}
		}
	}
	public static int getNum() {
		int n;
		try{
			n = scan.nextInt();
		}catch(Exception e) {
			scan.nextLine();
			out.println("�߸��� �Է��Դϴ�.");
			return getNum();
		}
		if(n>6||0>n) {
			
			out.println("�߸��� �Է��Դϴ�. 1~6�� �Է����ּ���.");
			return getNum();
		}
		return n;
	}
	
	public static int menu() {
		out.println("1.�Է� 2.��� 3.�˻� 4.���� 5.���� 6.����");
		out.print("����>> ");
		int no = getNum();
		// ����ó�� �� ��ȿ�� �˻�
		return no;
	}
	
	public static void run() {
		switch(menu()) {
		case 1 : input(); break;
		case 2 : output(); break;
		case 3 : searchData(); break;
		case 4 : modify(); break;
		case 5 : delete(); break;
		case 6 : end(); break;
		default : out.println("--- �ش� ���� �����ϴ�! ---");
		}
		System.out.println("------------------------------------");
	}
	public static void rankCheck() {
		for(int idx=0;idx<top;idx++) {
			sArr[idx].rank = idx+1;
		}
	}
	
	public static void searchData() {
		// TODO Auto-generated method stub
		System.out.println("::::: SEARCH :::::");
		out.println("�л��� ������ �˻��մϴ�.");
		out.print("�̸� : ");
		String name = scanN.nextLine();
		int dataIdx = search(name);
		if(dataIdx<0) out.println("�ش� �л��� ������ �Էµ��� �ʾҽ��ϴ�.");
		else {
			sArr[dataIdx].studentPrint();
			out.println("������ �˻��� �Ϸ�Ǿ����ϴ�.");
			
			
		}
	}

	private static void end() {
		System.out.println("::::: END :::::");
		System.out.println("���α׷� ����!");
		System.out.println("�����ϼ̽��ϴ�!");
		System.exit(0);
	}

	private static void delete() {
		System.out.println("::::: DELETE :::::");
		// �̸����� �˻� �� ����
		out.println("�л��� ������ �����մϴ�.");
		out.print("�Է� : ");
		String name = scanN.nextLine();
		int dataIdx = search(name);
		
		if(dataIdx<0) {
			out.println("�ش� �л��� ã���� �����ϴ�.");
		}else {
			
			for(int idx=dataIdx;idx<top;idx++) {
				sArr[idx]=sArr[idx+1];
			}
			top--;
			out.println("-----������ ������ �Ϸ��߽��ϴ�.-------");
		}
	}
	private static void modify() {
		System.out.println("::::: MODIFY :::::");
		// �̸����� �˻� �� ����
		out.println("�л��� ������ �����մϴ�.");
		out.print("�Է� : ");
		String name = scanN.nextLine();
		int dataIdx = search(name);
		if(dataIdx<0) {
			out.println("ã���ô� �л��� ������ �����ϴ�.");
		}else {
			out.println(sArr[dataIdx].name+"�� ������ �����մϴ�.");
			out.print("kor : ");
			int kor = scan.nextInt();
			out.print("eng : ");
			int eng = scan.nextInt();
			out.print("math : ");
			int math = scan.nextInt();
			sArr[dataIdx] = new Student(sArr[dataIdx].no, name,kor, eng, math);
			appointedRank();
			rankCheck();
		}
	}

	private static int search(String name) {
		// �̸����� �˻�
		for(int idx =0;idx<top;idx++) {
			Student sIdx = sArr[idx];
			if(name.compareTo(sIdx.name)==0)
				return idx;
		}
		return -1;
	}
	
	private static void output() {
		System.out.println(":::::::::::::::::::::::::::: OUTPUT ::::::::::::::::::::::::::::");
		// �迭�� ��� ���
		// ��ȣ, ����, ����, ����, ����, ����, ���, ����, ���, ����� �������� ����
		for(Student std : sArr) {
			if(std == null) break;
			out.println(std);
		}
	}
		private static String equalsName() {
		String name = scanN.nextLine();
		int dataIdx = search(name);
		if(dataIdx>0) {
			return name;
		}else {
			out.println("�ߺ��Ǵ� �̸��� �ֽ��ϴ�.");
			out.println("����Ͻðڽ��ϱ�?(Y/N)");
			String answer = scanN.nextLine();
			if("Y".equals(answer)==0||"y".equals(answer)==0)
				return name+"B";
			
		}
		
	}

	private static void input() {
		System.out.println("::::: INPUT :::::");
		// ����, ����, ����, ���и� �迭�� �Է� �޴´�.
		// �Է� ���� ������ ������ ������ ���, ����� ����, 
		// �Է� �� �л��� ����� ���� �ȴ�.
		out.print("�̸� : ");
		String name = scanN.nextLine();
		out.print("kor : ");
		int kor = scan.nextInt();
		out.print("eng : ");
		int eng = scan.nextInt();
		out.print("math : ");
		int math = scan.nextInt();
		sArr[top++] = new Student(sequence++, name,kor, eng, math);
		appointedRank();
		rankCheck();
		
	}

	public static void main(String[] args) {
		out.println("::::: ���� ��� ���α׷� :::::");
		while(true) {
			run();
		}
	}
}