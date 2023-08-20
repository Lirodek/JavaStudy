package board_pservice_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_p.model_p.BoardDAO;

public class BoardList implements BoardService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		request.setAttribute("mainUrl", "List");
		
		Object data = new BoardDAO().list();
		
		request.setAttribute("mainData", data);
		System.out.println("BoardList execute() 실행됨"+data);
	}
}
