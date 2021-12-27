package org.GamePlayer.Model;

import static java.lang.System.out;

public class GammerVo {
	private String tribe, name, grade;
	private int terran, zerg, protoss, sum, rank, member;
	private double avg;
	GammerVo(){
		this(0,"","",0,0,0);
	}
	public void avg() {
		int sum = (terran+zerg+protoss);
		this.avg  = sum/3;
		setGrade();
	}
	public GammerVo(int member, String name, String tribe, int terran, int protoss, int zerg) {
		// TODO Auto-generated constructor stub
		this.member = member;
		this.name = name;
		this.tribe = tribe;
		this.terran = terran;
		this.protoss =protoss;
		this.zerg = zerg;
		this.sum = protoss+zerg+terran;
		this.avg= sum/3;
		setGrade();
	}
	public String getTribe() {
		return tribe;
	}
	public void setTribe(String tribe) {
		this.tribe = tribe;
	}
	public void setGrade(String s) {
		this.grade =s;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public int getTerran() {
		return terran;
	}
	public void setTerran(int terran) {
		this.terran = terran;
		avg();
	}
	public int getZerg() {
		return zerg;
	}
	public void setZerg(int zerg) {
		this.zerg = zerg;
		avg();
		
		
	}
	public int getProtoss() {
		return protoss;
	}
	public void setProtoss(int protoss) {
		this.protoss = protoss;
		avg();
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
		
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "[" + rank + "]위\t" + grade + "\t" + name + "\t" + tribe + "\t"
				+ avg+"%\t"+member+"\t";
	}
	public void tribeShow(int i) {
		out.printf("%d위 %s\t [%s] 선수의 승률은 %.0f %% 입니다.\n",i,grade,name,avg);
	}
	public void GamerDeepShow() {
		out.printf("%d번 %d위 %s\t [%s] 선수의 \n종족은[%s]이고 승률은 %.0f %% 입니다.\n",member,rank,grade,name,tribe,avg);
		out.println("========================");
		out.println("저그전 : "+zerg+"%");
		
		out.println("테란전 : "+terran+"%");
		out.println("토스전 : "+protoss+"%");
	}
	public void setGrade() {
		if(avg>65) {
			grade= "S급";
		}
		else if(avg>60) {
			grade= "A급";
		}
		else if(avg>55) {
			grade= "B급";
		}
		else if(avg>50) {
			grade= "C급";
		}
		else {
			grade = "아마추어 급";
		}
	}
	
}
