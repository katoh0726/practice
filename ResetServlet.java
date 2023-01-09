package game;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResetServlet
 */
@WebServlet("/reset")
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		You you = new You();
		you.hp = 100;
		you.mp = 100;
		
		
		request.setAttribute("yourHP", you.hp);
		request.setAttribute("yourMP", you.mp);
		request.setAttribute("yourPower", you.power);

		Monster monster1 = new Monster();
		monster1.hp = 50;
		request.setAttribute("monstersHP", monster1.hp);
		request.setAttribute("monstersPower", monster1.power);

		
			RequestDispatcher dispatcher= 
					request.getRequestDispatcher("WEB-INF/game_jsp/start.jsp");
			dispatcher.forward(request,response);
			return;
	}

}
