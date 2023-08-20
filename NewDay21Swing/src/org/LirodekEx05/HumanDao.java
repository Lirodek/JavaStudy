package org.LirodekEx05;

import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

public class HumanDao {
	
	public static Vector<HumanDto> humanVec = new Vector<HumanDto>();
	
	static{
		humanVec.add(new HumanDto(1,"Kim", "kim@naver.com", "010-1111-1111"));
		humanVec.add(new HumanDto(2,"Lee", "lee@naver.com", "010-2222-2222"));
		humanVec.add(new HumanDto(3,"Park", "park@naver.com", "010-3333-3333"));
	}
	
	public static int sequence = 4;
	
	public Vector selectAll() {
		Vector vector = new Vector();
		for(int i=0;i<humanVec.size();i++) {
			vector.add(humanVec.get(i).toVector());
		}
		return vector;
	}
	
	public void insert(HumanDto humanDto) {
		if(!humanDto.getName().equals(null)) {
			humanDto.setIdx(sequence++);
			humanVec.add(humanDto);
		}
	}
	public HumanDto search(String name) {
		
		for(HumanDto vector : humanVec) {
			if(name.equals(vector.getName())) {
				HumanDto d = vector;
				return d;
			}
		}
		return null;
	}

	public boolean delete(String name) {
		HumanDto dto = search(name);
		if(dto == null) {
			return false;
		}else{
			humanVec.remove(dto);
			return true;
		}
		
	}
	private int adressSearch(String name) {
		int i=0;
		for(HumanDto vector : humanVec) {
			i++;
			if(name.equals(vector.getName())) {
				return i;
			}
		}
		return -1;
	}

	public boolean modify(String name, HumanDto dto) {
		try {
			
			int idx = adressSearch(name);
			humanVec.set(idx-1, dto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
