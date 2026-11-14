package ma.app.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		rd.forward(request,response);
	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			
			
			if ("admin".equals(username) && "password".equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("user", username);
			session.setMaxInactiveInterval(30 * 60); 
			
			// 30 min
			resp.sendRedirect("/TP3/Dashboard");
			} else {
			req.setAttribute("err", 1);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(req,resp);
			}
			}
			


}









