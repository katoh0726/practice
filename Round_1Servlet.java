package game;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Round_1Servlet
 */
@WebServlet("/round_1")
public class Round_1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Round_1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		You you = new You();
		Monster monster1 = new Monster();
		boolean attackFlg = false;
		boolean diffenceFlg = false;
		boolean healFlg = false;
		boolean skilFlg = false;
		
		HttpSession session = request.getSession(false);
		
		if(request.getParameter("active") != null) {
			int activeNo=Integer.parseInt(request.getParameter("active"));
			

			switch(activeNo) {
			case 1:
				monster1.hp -= you.power;
				you.hp -= monster1.power;
				attackFlg = true;
				break;
				
			case 2:
				you.hp += 20;
				you.mp -= 10;
				healFlg = true;
				break;
				
			case 3:
				you.hp -= monster1.power/2;
				diffenceFlg = true;
				break;
				
			case 4:
				you.hp -= monster1.power;
				you.skil();
				monster1.hp -=you.power;
				skilFlg = true;
				break;
				
			default:
				RequestDispatcher dispatcher= 
				request.getRequestDispatcher("WEB-INF/game_jsp/lose.jsp");
				dispatcher.forward(request,response);
				return;
			}
		}
		
		if(you.hp<=0) {
			RequestDispatcher dispatcher= 
					request.getRequestDispatcher("WEB-INF/game_jsp/lose.jsp");
			dispatcher.forward(request,response);
			return;}
		else if(monster1.hp<=0) {
			RequestDispatcher dispatcher= 
					request.getRequestDispatcher("WEB-INF/game_jsp/round_1Victory.jsp");
			dispatcher.forward(request,response);
			return;}
		
		request.setAttribute("yourHP", you.hp);
		request.setAttribute("yourMP", you.mp);
		request.setAttribute("yourPower", you.power);
		request.setAttribute("monstersHP", monster1.hp);
		request.setAttribute("monstersPower", monster1.power);
		request.setAttribute("attackFlg",attackFlg );
		request.setAttribute("healFlg", healFlg);
		request.setAttribute("diffenceFlg", diffenceFlg);
		request.setAttribute("skilFlg", skilFlg);
		if(request.getParameter("name") != null) {
			String name = request.getParameter("name");
			session.setAttribute("name", name);
		}
		

		
		RequestDispatcher dispatcher= 
				request.getRequestDispatcher("WEB-INF/game_jsp/round_1.jsp");
		dispatcher.forward(request,response);
		return;
	}

}
