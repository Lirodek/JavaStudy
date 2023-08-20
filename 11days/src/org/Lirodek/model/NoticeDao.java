package org.Lirodek.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NoticeDao {
	public static final int MAX =100;
	private static NoticeVo[] nArr = new NoticeVo[MAX];
	public static int noticeSeq = 1;
	public static int topCnt = 0;
	{
		nArr[topCnt++] = new NoticeVo(noticeSeq++,"유미","고기고기물고기다",getDate());
		nArr[topCnt++] = new NoticeVo(noticeSeq++,"유미","슝슝~ 해줄게",getDate());
		nArr[topCnt++] = new NoticeVo(noticeSeq++,"유미","야 책아 내가 꼭 지켜줄게",getDate());
		nArr[topCnt++] = new NoticeVo(noticeSeq++,"유미","궁극의 마법이다 야~아~아~",getDate());
	}
	public String getDate() {
		 LocalDateTime myDateObj = LocalDateTime.now();   
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시mm분ss초 의 저장되었습니다.");  
	    String formattedDate = myDateObj.format(myFormatObj);    
	    return formattedDate;
	}
	public NoticeVo[] selectAll() {
		NoticeVo[] newArr = new NoticeVo[topCnt];
		for(int i=0;i<newArr.length;i++) {
			NoticeVo noticeN = new NoticeVo();
			noticeN.setNo(nArr[i].getNo());
			noticeN.setUser(nArr[i].getUser());
			noticeN.setMessage(nArr[i].getMessage());
			noticeN.setRegDate(nArr[i].getRegDate());
			newArr[i] = noticeN;
		}
		return newArr;
	}
	private int search(NoticeVo vo) {
		for(int i=0;i<topCnt;i++) {
			if(nArr[i].getNo()==vo.getNo())
				return i;
		}
		return-1;
	}
	public NoticeVo selectOne(NoticeVo vo) {
		int i = search(vo);
		if(i<0) return null;
		else {
			NoticeVo noticeN = new NoticeVo();
			noticeN.setNo(nArr[i].getNo());
			noticeN.setUser(nArr[i].getUser());
			noticeN.setMessage(nArr[i].getMessage());
			noticeN.setRegDate(nArr[i].getRegDate());
			return noticeN;
		}
	}
	public NoticeVo selectByno(int no) {
		NoticeVo[] newArr = new NoticeVo[topCnt];
		for(int i=0;i<newArr.length;i++) {
			NoticeVo noticeN = new NoticeVo();
			noticeN.setNo(nArr[i].getNo());
			noticeN.setUser(nArr[i].getUser());
			noticeN.setMessage(nArr[i].getMessage());
			noticeN.setRegDate(nArr[i].getRegDate());
			if(noticeN.getNo()==no) {
				return noticeN;
			}
		}
		return null;
	}
	public void update(NoticeVo vo) {
		int i = search(vo);
		nArr[i] = new NoticeVo(nArr[i].getNo(),vo.getUser(),vo.getMessage(),vo.getRegDate());
	}
	public void delete(NoticeVo vo) {
		int idx = search(vo);
		if(idx>=0||idx<topCnt) {
			for(int j=idx;j<topCnt-1;j++) {
				nArr[j]=nArr[j+1];
			}
			topCnt--;
			nArr[topCnt]=null;
		}
		
	}
	public void insert(NoticeVo vo) {
		vo.setNo(noticeSeq++);
		nArr[topCnt++] = vo;
		System.out.println(topCnt+"번째 메모로 저장됨");
	}
	public NoticeVo[] nameSearch(NoticeVo vo) {
		NoticeVo[] newArr = new NoticeVo[topCnt];
		int temp=0;
		for(int i=0;i<newArr.length;i++) {
				NoticeVo noticeN = new NoticeVo();
				noticeN.setNo(nArr[i].getNo());
				noticeN.setUser(nArr[i].getUser());
				noticeN.setMessage(nArr[i].getMessage());
				noticeN.setRegDate(nArr[i].getRegDate());
				if(noticeN.getUser().equals(vo.getUser())) {
					newArr[temp++] = noticeN;
				}
		}
		for(int i=0;i<temp;i++) {
			if(newArr[i]==null)return null;
			newArr[i].print();
		}
		return newArr;
	}
}
