package org.LiroSelf.Model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class DataAcess {
	private static DataMake dto;
	private static ArrayList<DataMake> dtoList = new ArrayList<>();
	private static int num=0;
	
	static{
		bringFile();
	}
	public void SaveFile() {
		
		try {
			FileWriter file1 = new FileWriter(ConstDir.FILE);
			JSONArray jArray = new JSONArray();
			System.out.println("파일저장");
			Iterator<DataMake> itr = dtoList.iterator();
			while(itr.hasNext()) {
				dto = itr.next();
				JSONObject jobj = new JSONObject();
				jobj.put("번호", dto.getNo());
				jobj.put("회원번호", dto.getSpecialNumber());
				jobj.put("이름", dto.getName());
				jobj.put("나이", dto.getAge());
				jobj.put("휴대폰", dto.getPhoneNumber());
				jobj.put("성별", dto.getSex());
				jobj.put("국가", dto.getNation());
				jobj.put("언어", dto.getRanguage());
				jArray.put(jobj);
			}
			JSONObject root1 = new JSONObject();
			root1.put("member", jArray);
			file1.write(root1.toString());
			file1.close();
			
		} catch(JSONException e) {
			System.out.println("저장할 데이터가 존재하지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void bringFile() {
		File file = new File(ConstDir.FILE);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			JSONTokener jtk = new JSONTokener(bis);
			JSONObject fileObj = new JSONObject(jtk);
			JSONArray jArray = new JSONArray();
			jArray = fileObj.getJSONArray("member");
			for(int i=0;i<jArray.length();i++) {
				JSONObject tempJobj = new JSONObject();
				tempJobj = (JSONObject) jArray.get(i);
				dto.setNo(Integer.valueOf(tempJobj.getString("번호")));
				dto.setSpecialNumber(tempJobj.getString("회원번호"));
				dto.setName(tempJobj.getString("이름"));
				dto.setAge(Integer.valueOf(tempJobj.getString("나이")));
				dto.setPhoneNumber(tempJobj.getString("휴대폰"));
				dto.setSex(tempJobj.getString("성별"));
				dto.setNation(tempJobj.getString("국가"));
				dto.setRanguage(tempJobj.getString("언어"));
				dtoList.add(dto);
				System.out.println(dto.toString());
			}
		} catch (FileNotFoundException e) {}
		  catch (JSONException e) {}
	}
	public static ArrayList<DataMake> selectAll(){
		return dtoList;
	}
	
	public void dataInsert(DataMake inputData) {
		
		int no = num++;
		secretNumber(inputData);	
		dtoList.add(inputData);
		SaveFile();
	}
	public boolean dataDelete(String UserCode) {
		Iterator<DataMake> itr = dtoList.iterator();
		while(itr.hasNext()) {
			dto = itr.next();
			if(dto.getSpecialNumber().equals(UserCode)) {
				dtoList.remove(dto);
				SaveFile();
				return true;
			}
				
		}
		return false;
	}
	private void secretNumber(DataMake inputData) {//고유번호 부여하는 알고리즘
		int nationCode = inputData.getNation().charAt(0);
		nationCode /= 10000;
		int phoneCode1 = inputData.getPhoneNumber().charAt(1);
		int sexCode = inputData.getSex().charAt(0);
		sexCode /= 10000;
		int raguCode = inputData.getRanguage().length();
		
		String scretCode = nationCode+""+
				phoneCode1+""+sexCode+""+raguCode+num;
		inputData.setSpecialNumber(scretCode);
		inputData.setNo(num);
		inputData.setRanguage(inputData.getRanguage().trim());
		
		
	}
	public DataMake searchData(String name) {
		Iterator<DataMake> itr = dtoList.iterator();
		while(itr.hasNext()) {
			dto = itr.next();
			if(dto.getName().equals(name))
				return dto;
		}
		return null;
	}
	
	
	
	
	
	
	
}
