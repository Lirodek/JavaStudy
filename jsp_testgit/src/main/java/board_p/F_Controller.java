package board_p;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_pservice_p.BoardList;
import board_pservice_p.BoardService;

/**
 * Servlet implementation class F_Controller
 */
@WebServlet("/board/*")
public class F_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
//		System.out.println(request.getRequestURI());
//		System.out.println(request.getContextPath());
		String serviceStr = request.getRequestURI().substring(
				(request.getContextPath()+"/board/").length()
				);
		System.out.println(serviceStr);
		
		try {
			BoardService service = (BoardService)Class.forName("board_pservice_p.Board"+serviceStr).newInstance();
			
			service.execute(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("mainUrl", serviceStr);
		
		System.out.println("doGet() 왔다감");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/bbb_view/template.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
