package org.Lirodek.HumanModel;

//루즈 커플링 (결합도)
//응집력은 높여라 
//SOLID 5원칙★
//SRP SingleResponsibility Principle 단일책임원칙
//OCP Open Closed Principle 개방 폐쇄 원칙
//LSP Liskov Substitution Principle 리스코프 치환 원칙
//ISP Interface Segregation Principle 인터페이스 분리 원칙
//DIP Dependency Inversion Principle 의존 역전 원칙

import static java.lang.System.out;
public class HumanDAO {
	//임시로 배열에 저장하도록 구현한후 DB연동, 또는 파일io로 처리
	private static final int MAX=100;
	private static final HumanVo[] humanArr = new HumanVo[MAX];
	public static int topCnt=0;
	public static int sequenceMem = 1;//절대 감소가 안되는 요소
	
	static {
		humanArr[topCnt++] = new HumanVo(sequenceMem++,"KIM","010-1111-1111","kim@comstudy.org");
		humanArr[topCnt++] = new HumanVo(sequenceMem++,"LEE","010-2222-2222","lee@comstudy.org");
		humanArr[topCnt++] = new HumanVo(sequenceMem++,"PARK","010-3333-3333","park@comstudy.org");
	}
	
	//전체출력
	public HumanVo[] selectAll() {
		//humanArr과 참조끊기
		HumanVo[] newArr = new HumanVo[topCnt];
		for(int idx=0;idx<newArr.length;idx++) {
			HumanVo newHuman = new HumanVo();
			newHuman.setMember(humanArr[idx].getMember());
			newHuman.setName(humanArr[idx].getName());
			newHuman.setPhone(humanArr[idx].getPhone());
			newHuman.setEmail(humanArr[idx].getEmail());
			newArr[idx]= newHuman;
		}//<생각좀해보기
		return newArr;
	}//상세보기 이름으로 검색하기
	public HumanVo selectOne(HumanVo vo) {
		//1.검색하기
		//2.같은 요가가 존재 하면 복재해서 반환(return)
		for(int i=0; i<topCnt;i++) {
			if(vo.getName().equals(humanArr[i].getName()))
			{
				HumanVo newHuman = new HumanVo();
				newHuman.setMember(humanArr[i].getMember());
				newHuman.setName(humanArr[i].getName());
				newHuman.setPhone(humanArr[i].getPhone());
				newHuman.setEmail(humanArr[i].getEmail());
				return newHuman;
			}
		}
		return null;
	}//상세보기 이름으로 검색하기
	public HumanVo selectNo(int member) {
		//1.검색하기
		//2.같은 요가가 존재 하면 복재해서 반환(return)
		for(int i=0; i<topCnt;i++) {
			if(member==humanArr[i].getMember())
			{
				HumanVo newHuman = new HumanVo();
				newHuman.setMember(humanArr[i].getMember());
				newHuman.setName(humanArr[i].getName());
				newHuman.setPhone(humanArr[i].getPhone());
				newHuman.setEmail(humanArr[i].getEmail());
				return newHuman;
			}
		}
		return null;
	}//입력
	public void insert(HumanVo vo) {
		if(topCnt>=MAX) {
			out.println("더이상 입력이 불가능합니다.!");
			return;
		}
		vo.setMember(sequenceMem++);
		humanArr[topCnt++] = vo;
	}//수정
	public void update(HumanVo vo) {
		//검색해서 같은 요소가 있다면 수정하기 member로 검색해서 idx찾기.
		for(int i=0;i<topCnt;i++) {
			if(humanArr[i].getMember()==vo.getMember()) {
				humanArr[i]=vo;
			}
		}
		
	}//삭제
	private int dataCheck(HumanVo vo) {
		for(int i=0;i<topCnt;i++) {
			if(humanArr[i].getName().equals(vo.getName()))
				return i;
		}
		return -1;
	}
	public void delete(HumanVo vo) {
		//no검색하기
		//같은 요소가 있다면 한칸씩 당기기
		//마지막 요소는 null 변경하고 탑감소
		int idx= dataCheck(vo);
		if(idx<0) System.out.println("찾을수 없습니다.");
		else{
				for(int j=idx;j<topCnt-1;j++) {
					humanArr[j]=humanArr[j+1];
				}
				humanArr[topCnt-1]=null;
				topCnt--;
			}
		}
}
