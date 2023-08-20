package board_p.model_p;

import java.util.Date;

public class BoardDTO {
	int id, cnt;
	Date reg_date;
	String p_name, pw, title, content, upfile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpfile() {
		return upfile;
	}
	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}
	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", cnt=" + cnt + ", reg_date=" + reg_date + ", p_name=" + p_name + ", pw=" + pw
				+ ", title=" + title + ", content=" + content + ", upfile=" + upfile + "]";
	}
	
}
