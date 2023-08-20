package org.LiroSelf.Model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import JdbcUtill.JdbcUtill;

public class DataAcess {
	private static final String SQL_INSET = "INSERT INTO LIRODEK1(no, name, age, phone, gender, nation, ranguage, special) values(?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE LIRODEK1 SET NAME=?, AGE=?, PHONE=?, GENDER=?, NATION=?, RAUNGUAGE=?";
	private static final String SQL_DELETE = "DELETE FROM LIRODEK1 WHERE SPECIAL = ?";
	private static final String SQL_SELECT_NAME = "SELECT * FROM LIRODEK1 WHERE SPECIAL = ?";
	private static final String SQL_SELECT = "SELECT * FROM LIRODEK1";

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private List<DataMake> dtoList = null;
	private static DataMake dto;

	private static int num = 0;

	public List<DataMake> selectAll() {
		dtoList = new ArrayList<DataMake>();
		try {
			conn = JdbcUtill.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT);
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String phone = rs.getString(4);
				String gender = rs.getString(5);
				String nation = rs.getString(6);
				String ranguage = rs.getString(7);
				String special = rs.getString(8);
				dto = new DataMake(no, name, age, phone, gender, nation, ranguage, special);
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtoList;
	}

	public void dataInsert(DataMake inputData) {

		int no = num++;
		secretNumber(inputData);
		conn = JdbcUtill.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL_INSET);
			pstmt.setInt(1, inputData.getNo());
			pstmt.setString(2, inputData.getName());
			pstmt.setInt(3, inputData.getAge());
			pstmt.setString(4, inputData.getPhoneNumber());
			pstmt.setString(5, inputData.getSex());
			pstmt.setString(6, inputData.getNation());
			pstmt.setString(7, inputData.getRanguage());
			pstmt.setString(8, inputData.getSpecialNumber());
			int cnt = pstmt.executeUpdate();
			if (cnt == 0) {
				System.out.println("입력 실패");
				conn.rollback();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("SQL오류");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {

				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	public boolean dataDelete(String UserCode) {
		conn = JdbcUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setString(1, UserCode);
			int cnt = pstmt.executeUpdate();
			if (cnt == 0)
				return false;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return true;
	}

	private void secretNumber(DataMake inputData) {// 고유번호 부여하는 알고리즘
		int nationCode = inputData.getNation().charAt(0);
		nationCode /= 10000;
		int phoneCode1 = inputData.getPhoneNumber().charAt(1);
		int sexCode = inputData.getSex().charAt(0);
		sexCode /= 10000;
		int raguCode = inputData.getRanguage().length();

		String scretCode = nationCode + "" + phoneCode1 + "" + sexCode + "" + raguCode + num;
		inputData.setSpecialNumber(scretCode);
		inputData.setNo(num);
		inputData.setRanguage(inputData.getRanguage().trim());

	}

	public Vector<DataMake> searchData(String name) {
		Vector dataVec = new Vector();
		Iterator<DataMake> itr = dtoList.iterator();
		while (itr.hasNext()) {
			dto = itr.next();
			if (dto.getName().equals(name))
				dataVec.add(dto);
		}
		if (dataVec == null) {
			return null;
		} else {
			return dataVec;
		}
	}

	public boolean checkPhoneNumber(String phoneNumber) {
		Iterator<DataMake> itr = dtoList.iterator();
		while (itr.hasNext()) {
			dto = itr.next();
			if (dto.getPhoneNumber().equals(phoneNumber))
				return true;
		}
		return false;
	}

}
