package org.GamePlayer.Model;

import static java.lang.System.out;

public class GamerDAO {
	private static final int MAX = 100;
	private static final GammerVo[] gameArr = new GammerVo[MAX];
	public static int topCnt=0;
	public static int sequenceMem=1;
	{                                         //     저그 테란 토스
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"염보성","테란",59,62,55);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"전상욱","테란",63,55,58);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"이윤열","테란",62,61,59);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"정명훈","테란",61,60,65);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"매정우","저그",60,63,64);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"송병구","플토",59,67,61);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"최연성","테란",69,60,63);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"김택신","플토",70,65,64);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"이제동","저그",73,63,69);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"허영무","플토",57,63,57);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"김윤환","저그",61,48,54);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"박정석","플토",47,58,48);
		gameArr[topCnt++] = new GammerVo(sequenceMem++,"임요환","테란",65,54,53);
		BubleStrime();
	}
	public GammerVo[] selectAll() {//복제
		GammerVo[] newArr = new GammerVo[topCnt];
		for(int i=0;i<newArr.length;i++) {
			GammerVo newGame = new GammerVo();
			newGame.setMember(gameArr[i].getMember());
			newGame.setName(gameArr[i].getName());
			newGame.setTribe(gameArr[i].getTribe());
			newGame.setTerran(gameArr[i].getTerran());
			newGame.setProtoss(gameArr[i].getProtoss());
			newGame.setZerg(gameArr[i].getZerg());
			newGame.setAvg(gameArr[i].getAvg());
			newGame.setRank(gameArr[i].getRank());
			newGame.setGrade(gameArr[i].getGrade());
			newArr[i]=newGame;
		}
		BubleStrime();
		return newArr;
	}
	private void BubleStrime() {
		int temp=99;
		for(int i=0;i<topCnt;i++) {
			for(int j=0;j<topCnt-1;j++) {
				if(gameArr[j].getAvg()<gameArr[j+1].getAvg()) {
					gameArr[temp]=gameArr[j];
					gameArr[j]=gameArr[j+1];
					gameArr[j+1]=gameArr[temp];
				}
					
			}
		}
		for(int i=0;i<topCnt;i++) {
			gameArr[i].setRank(i+1);
		}
	}

	public void inputData(GammerVo vo) {//1
		if(topCnt>=MAX) {
			System.out.println("더이상 입력이 불가능합니다.!");
			return;
		}
		vo.setMember(sequenceMem++);
		gameArr[topCnt++]=vo;
		BubleStrime();
	}
//	public void modiData(GammerVo vo) {
//		for(int i=0;i<topCnt;i++) {
//			if(gameArr[i].getMember()==vo.getMember())
//				gameArr[i]=vo;
//			if(gameArr[i].getName().equals(vo.getName()))
//				gameArr[i]=vo;
//		}
//	}
	private int dataCheck(GammerVo vo) {
		for(int i=0;i<topCnt;i++) {
			if(gameArr[i].getName().equals(vo.getName()))
				return i;
		}
		return -1;
	}
	public void delete(GammerVo vo) {
		int idx = dataCheck(vo);
		if(idx<0) {
			noOne();
			return;
		}
		else {
				for(int j=idx;j<topCnt-1;j++) {
					gameArr[j]=gameArr[j+1];
				}
				gameArr[topCnt-1]=null;
				topCnt--;
				BubleStrime();
				System.out.println("삭제완료");
		}
	}
	public void gameModi(GammerVo vo) {
		int idx = dataCheck(vo);
		if(idx<0) {
			noOne();
			return;
		}
		else {
			if(!(vo.getTribe().equals(null))) {
				GammerVo newGame = new GammerVo();
				newGame.setMember(gameArr[idx].getMember());
				newGame.setName(gameArr[idx].getName());
				newGame.setTribe(vo.getTribe());
				newGame.setTerran(vo.getTerran());
				newGame.setProtoss(vo.getProtoss());
				newGame.setZerg(vo.getZerg());
				newGame.setAvg(vo.avg());
				newGame.setGrade(vo.getGrade());
				gameArr[idx]=newGame;
				BubleStrime();
				return;
			}
			if(!(vo.getTerran()!=0)) {
				GammerVo newGame = new GammerVo();
				newGame.setMember(gameArr[idx].getMember());
				newGame.setName(gameArr[idx].getName());
				newGame.setTribe(gameArr[idx].getTribe());
				newGame.setTerran(vo.getTerran());
				newGame.setProtoss(gameArr[idx].getProtoss());
				newGame.setZerg(gameArr[idx].getZerg());
				newGame.setAvg(gameArr[idx].getAvg());
				newGame.setRank(gameArr[idx].getRank());
				newGame.setGrade(gameArr[idx].getGrade());
				gameArr[idx]=newGame;
				BubleStrime();
				return;
			}
			if(!(vo.getProtoss()!=0)) {
				GammerVo newGame = new GammerVo();
				newGame.setMember(gameArr[idx].getMember());
				newGame.setName(gameArr[idx].getName());
				newGame.setTribe(gameArr[idx].getTribe());
				newGame.setTerran(gameArr[idx].getTerran());
				newGame.setProtoss(vo.getProtoss());
				newGame.setZerg(gameArr[idx].getZerg());
				newGame.setAvg(gameArr[idx].getAvg());
				newGame.setRank(gameArr[idx].getRank());
				newGame.setGrade(gameArr[idx].getGrade());
				gameArr[idx]=newGame;
				BubleStrime();
				return;
			}
			if(!(vo.getZerg()!=0)) {
				GammerVo newGame = new GammerVo();
				newGame.setMember(gameArr[idx].getMember());
				newGame.setName(gameArr[idx].getName());
				newGame.setTribe(gameArr[idx].getTribe());
				newGame.setTerran(gameArr[idx].getTerran());
				newGame.setProtoss(gameArr[idx].getProtoss());
				newGame.setZerg(vo.getZerg());
				newGame.setAvg(gameArr[idx].getAvg());
				newGame.setRank(gameArr[idx].getRank());
				newGame.setGrade(gameArr[idx].getGrade());
				gameArr[idx]=newGame;
				BubleStrime();
				return;
			}
		}
			
		
	}
	private void zergViewer() {
		int trank=1;
		System.out.println("Zerg 현황");
		GammerVo[] newArr = new GammerVo[topCnt];
		for(int i=0;i<newArr.length;i++) {
			if(gameArr[i].getTribe().equals(TRIBE_VAL.ZERG)) {
				GammerVo newGame = new GammerVo();
				newGame.setMember(gameArr[i].getMember());
				newGame.setName(gameArr[i].getName());
				newGame.setTribe(gameArr[i].getTribe());
				newGame.setTerran(gameArr[i].getTerran());
				newGame.setProtoss(gameArr[i].getProtoss());
				newGame.setZerg(gameArr[i].getZerg());
				newGame.setAvg(gameArr[i].getAvg());
				newGame.setRank(gameArr[i].getRank());
				newGame.setGrade(gameArr[i].getGrade());
				newArr[i]=newGame;
				trank++;
			}
		}
		for(int i=0;i<trank;i++) {
			if(newArr[i].getName().equals(null))
				return;
			newArr[i].tribeShow(i);
		}
		
		if(trank==1) out.println("등록된 게이머가 없습니다.");
	}
	private void protossViewer() {
		int trank=1;
		System.out.println("Protoss 현황");
		GammerVo[] newArr = new GammerVo[topCnt];
		for(int i=0;i<newArr.length;i++) {
			if(gameArr[i].getTribe().equals(TRIBE_VAL.PROTOSS)) {
				GammerVo newGame = new GammerVo();
				newGame.setMember(gameArr[i].getMember());
				newGame.setName(gameArr[i].getName());
				newGame.setTribe(gameArr[i].getTribe());
				newGame.setTerran(gameArr[i].getTerran());
				newGame.setProtoss(gameArr[i].getProtoss());
				newGame.setZerg(gameArr[i].getZerg());
				newGame.setAvg(gameArr[i].getAvg());
				newGame.setRank(gameArr[i].getRank());
				newGame.setGrade(gameArr[i].getGrade());
				newArr[i]=newGame;
				trank++;
			}
		}
		for(int i=0;i<trank;i++) {
			if(newArr[i].getName().equals(null))
				return;
			newArr[i].tribeShow(i);
		}
		
		if(trank==1) out.println("등록된 게이머가 없습니다.");
	}
	public GammerVo searchData(GammerVo vo) {
		int i =dataCheck(vo);
		if(i<0) System.out.println("해당선수를 찾지못했습니다.");
		else {
				GammerVo newGame = new GammerVo();
				newGame.setMember(gameArr[i].getMember());
				newGame.setName(gameArr[i].getName());
				newGame.setTribe(gameArr[i].getTribe());
				newGame.setTerran(gameArr[i].getTerran());
				newGame.setProtoss(gameArr[i].getProtoss());
				newGame.setZerg(gameArr[i].getZerg());
				newGame.setAvg(gameArr[i].getAvg());
				newGame.setRank(gameArr[i].getRank());
				newGame.setGrade(gameArr[i].getGrade());
				return newGame;
			
		}
		return null;
	}
	private void terranViewer() {
		int trank=1;
		System.out.println("Terran 현황");
		GammerVo[] newArr = new GammerVo[topCnt];
		for(int i=0;i<newArr.length;i++) {
			if(gameArr[i].getTribe().equals(TRIBE_VAL.TERRAN)) {
				GammerVo newGame = new GammerVo();
				newGame.setMember(gameArr[i].getMember());
				newGame.setName(gameArr[i].getName());
				newGame.setTribe(gameArr[i].getTribe());
				newGame.setTerran(gameArr[i].getTerran());
				newGame.setProtoss(gameArr[i].getProtoss());
				newGame.setZerg(gameArr[i].getZerg());
				newGame.setAvg(gameArr[i].getAvg());
				newGame.setRank(gameArr[i].getRank());
				newGame.setGrade(gameArr[i].getGrade());
				newArr[i]=newGame;
				trank++;
			}
		}
		for(int i=0;i<trank;i++) {
			if(newArr[i].getName().equals(null))
				return;
			newArr[i].tribeShow(i);
		}
		
		if(trank==1) out.println("등록된 게이머가 없습니다.");
	}
	
	public void tribeView(GammerVo vo) {
		switch(vo.getTribe()) {
		case TRIBE_VAL.ZERG:
			zergViewer();
			break;
		case TRIBE_VAL.PROTOSS:
			protossViewer();
			break;
		case TRIBE_VAL.TERRAN:
			terranViewer();
			break;
		}
		
	}
	private void noOne() {
		System.out.println("찾을수 없습니다.");
	}
}
