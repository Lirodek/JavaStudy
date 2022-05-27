package jdbc_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	
	Connection con;
	//Statement stmt;
	PreparedStatement stmt;
	ResultSet rs;
	String sql;
	
	public MemberDAO() {
		String url = "jdbc:mariadb://localhost:3306/board";
		String username = "root";
		String password = "1234";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			//stmt = con.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> list(int marriage){
		ArrayList<MemberDTO> res = new ArrayList<MemberDTO>();
		
		sql = "SELECT * FROM member WHERE marriage = " + marriage;
		
		System.out.println(sql);
		try {
			
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setPid(rs.getString("pid"));
				dto.setPname (rs.getString("pname"));
				dto.setAge  (rs.getInt("age"));
				dto.setMarriage(rs.getInt("marriage"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				
				res.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	} 
	
	
	
	
	public int insert(MemberDTO dto){
		
		int res = 0;
		/*
		 * sql = "INSERT INTO member " +
		 * "(pid, pname,pw, age,marriage,reg_date) VALUES " + "('"+dto.pid
		 * +"','"+dto.pname +"','"+dto.pw +"',"+dto.age +","+dto.getMarriageInt()
		 * +",SYSDATE())" ;
		 */
		
		sql = "INSERT INTO member "
				+ "(pid, pname,pw, age,marriage,reg_date) VALUES "
				+ "( ?, ?, ?, ?, ?, SYSDATE())";
		
		System.out.println(sql);
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, dto.pid);
			stmt.setString(2, dto.pname);
			stmt.setString(3, dto.pw);
			stmt.setInt(4, dto.age);
			stmt.setInt(5, dto.getMarriageInt());
			
			res = stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			close();
		}
		
		return res;
	}
	
	
	
	public MemberDTO detail(MemberDTO dto){
		MemberDTO res = null;
		
		//sql = "SELECT * FROM member WHERE pid = '"+dto.pid+"' and pw = '"+dto.pw+"'";
		
		sql = "SELECT * FROM member WHERE pid = ? and pw = ? ";
		System.out.println(sql);
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, dto.pid);
			stmt.setString(2, dto.pw);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				res = new MemberDTO();
				res.setPid(rs.getString("pid"));
				res.setPname (rs.getString("pname"));
				res.setAge  (rs.getInt("age"));
				res.setMarriage(rs.getInt("marriage"));
				res.setReg_date(rs.getTimestamp("reg_date"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	} 
	
	
	
	
	public int insert2(MemberDTO dto){
		
		int res = 0;
		
		sql = "INSERT INTO member "
				+ "(pid, pname,pw, age,marriage,reg_date, pic, myff) VALUES "
				+ "( ?, ?, ?, ?, ?, SYSDATE(), ?,?)";
		
		System.out.println(sql);
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, dto.pid);
			stmt.setString(2, dto.pname);
			stmt.setString(3, dto.pw);
			stmt.setInt(4, dto.age);
			stmt.setInt(5, dto.getMarriageInt());
			stmt.setString(6, dto.pic);
			stmt.setString(7, dto.myff);
			
			res = stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			close();
		}
		
		return res;
	}
	
	
	
	public void close() {
		
		if(rs!=null) try { rs.close();} catch (SQLException e) {}
		if(stmt!=null) try { stmt.close();} catch (SQLException e) {}
		if(con!=null) try { con.close();} catch (SQLException e) {}
	}
	

}
