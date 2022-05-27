package board_pservice_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_p.model_p.BoardDAO;

public class BoardDetail implements BoardService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		int id= Integer.parseInt(request.getParameter("id"));
			
		BoardDAO dao = new BoardDAO();
		
		dao.addCount(id);
		
		Object data = new BoardDAO().detail(id);
		
		request.setAttribute("dto", data);
		request.setAttribute("mainUrl", "Detail");
		System.out.println("BoardList execute() 실행됨"+data);
	}
}
