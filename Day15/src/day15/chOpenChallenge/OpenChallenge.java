package day15.chOpenChallenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
class Word {
	private String eng;
	private String kor;
	Word(){
		this("","");
	}
	public Word(String eng, String kor) {
		this.eng = eng;
		this.kor = kor;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	@Override
	public int hashCode() {
		return Objects.hash(eng, kor);
	}
	@Override
	public String toString() {
		return eng + " : " + kor + "\n";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(eng, other.eng) && Objects.equals(kor, other.kor);
	}
	
}
public class OpenChallenge {
	Vector<Word> v = new Vector<Word>();
	Random rand = new Random();
	private static Scanner sc = new Scanner(System.in);
	{
		v.add(new Word("Love","사랑"));
		v.add(new Word("Animal","동물"));
		v.add(new Word("Beast","짐승"));
		v.add(new Word("Tiger","호랑이"));
		v.add(new Word("Moster","괴물"));
		v.add(new Word("Star","별"));
		v.add(new Word("Galaxy","은하"));
		v.add(new Word("GwangMin","광민"));
		v.add(new Word("fucking","시발"));
		v.add(new Word("Off work","퇴근"));
		v.add(new Word("Breakfast","아침"));
		v.add(new Word("Solo","혼자"));
		v.add(new Word("University","대학"));
		v.add(new Word("Loneliness","외로움"));
		v.add(new Word("Eevee","이브이"));
		v.add(new Word("Complex","열등감"));
		v.add(new Word("Bear","곰"));
		v.add(new Word("Nuclear","김정은"));
		
	}
	
	public OpenChallenge() {
		start();
	}

	private void start() {
		menu();
		game();
	}

	private void game() {
		Collections.shuffle(v);
		Iterator<Word> itr = v.iterator();
		while(itr.hasNext()) {
			Word w = itr.next();
			System.out.println(w.getEng()+"?");
			String[] mix = mix(w.getKor());
			for(int i=0;i<mix.length;i++) {
				System.out.print("("+(i+1)+")"+mix[i]+" ");
			}
			System.out.print(">");
			int choice = sc.nextInt();
			if(choice==-1) {
				System.out.println("\"명품영어\" 를 종료합니다 . . .");
				System.exit(0);
			}
			String key = mix[choice-1].trim();
			if(key.equals(w.getKor()))
				System.out.println("Excelent !!");
			else
				System.out.println("No !!");
		}
	}

	private String[] mix(String getKor) {
		String[] mix=new String[4];
		mix[0] = getKor;
		Set<String> set = new HashSet<String>(Arrays.asList(mix));
		int randI;
		for(int i=1;i<4;i++) {
			randI = rand.nextInt(v.size());
			mix[i] = v.get(randI).getKor();
			set = new HashSet<String>(Arrays.asList(mix));
		}
		if(set.size()>4) {
			
			return mix(getKor);
		}
		mix = set.toArray(new String[0]);
		
		return mix;
		
	}

	private void menu() {
		System.out.println("명품단어 테스트를 시작합니다.\n-1을 입력하면 종료합니다.");
		game();
		
	}

	public static void main(String[] args) {
		new OpenChallenge();

	}

}
