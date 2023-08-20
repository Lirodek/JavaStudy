package board_p.model_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	Connection con;
	// Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;

	public BoardDAO() {
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/qazxsw");
			con = ds.getConnection();
			
			//stmt = con.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDTO> list(){
		ArrayList<BoardDTO> res = new ArrayList<BoardDTO>();
		sql = "select * from board";
		
		try {
			pstmt = con.prepareStatement(sql); 
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setId(rs.getInt("id"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setTitle(rs.getString("title"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				dto.setP_name(rs.getString("pname"));
				
				
				res.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
		
		return res;
	}
	
	public BoardDTO detail(int id){
		BoardDTO dto = null;
		sql = "select * from board where id = ?";
		
		try {
			pstmt = con.prepareStatement(sql); 
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO();
				
				dto.setId(rs.getInt("id"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setTitle(rs.getString("title"));
				dto.setP_name(rs.getString("pname"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				dto.setUpfile(rs.getString("upfile"));
				dto.setContent(rs.getString("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
		
		return dto;
	}
	
	public void addCount(int id) {
		sql = "update board set cnt = cnt + 1 where id = ?";
		
		try {
			pstmt = con.prepareStatement(sql); 
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	public void close() {

		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
			}
	}

	
}
