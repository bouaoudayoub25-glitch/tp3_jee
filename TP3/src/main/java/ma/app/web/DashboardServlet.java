package ma.app.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;

/**
 * Servlet implementation class DashboardServlet
 */









@WebServlet("/Dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO 1 : récupérer "user" dans la session (sans créer de session)
		// TODO 2 : le placer dans la requête : req.setAttribute("user", ...)
		// TODO 3 : forward vers /WEB-INF/views/dashboard.jsp
		
	
		String user = (String) request.getSession().getAttribute("user");
		
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
		rd.forward(request,response);
		}
	
	
		
	
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
