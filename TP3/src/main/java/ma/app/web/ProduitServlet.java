package ma.app.web;
import ma.app.model.Produit;
import ma.app.model.ProduitDAO;
import ma.app.util.FlashMessage;
import ma.app.util.ProduitMapper;
import ma.app.util.ProduitValidator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


import java.util.Map;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/Produits")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() {
		ServletContext ctx = getServletContext();
		dao=(ProduitDAO)ctx.getAttribute("produitDAO");
	}
	
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd;
		
		String action =request.getParameter("action");
		if(action==null) action="lister";
		
		switch(action) {
		case "lister":
			
			request.setAttribute("produits", dao.findAll());
			request.setAttribute("message", FlashMessage.consume(request.getSession()));
			  
			rd = request.getRequestDispatcher("/WEB-INF/views/produits/list.jsp");
			
			break;
			
		case "new":
			rd = request.getRequestDispatcher("/WEB-INF/views/produits/form.jsp");
			break;
			
		case "edit":
			String id=request.getParameter("id");
			if(id==null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404
				return;
			}
			Produit p ;
			try {
				 p = dao.findById(Long.parseLong(id));
				
			}catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
			if (p == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
			request.setAttribute("produit",p);
			rd = request.getRequestDispatcher("/WEB-INF/views/produits/form.jsp");
			break;
		default:
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
				
		}
		
		
		rd.forward(request,response);
		}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session =request.getSession();
	
		String action = request.getParameter("action");
		String idParam=request.getParameter("id");
		
		if("delete".equals(action)) {
			try {
				dao.delete(Long.parseLong(idParam));
			}catch(Exception e) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	            return;
			}
			
			FlashMessage.set(session, "Produit supprime" );
	        response.sendRedirect(request.getContextPath() + "/Produits");
	        return;
		}
		
		    Produit p = ProduitMapper.fromRequest(request);
		    
		    String prixStr = ProduitMapper.clean(request.getParameter("prix")).replace(',', '.');
		    String stockStr = ProduitMapper.clean(request.getParameter("stock"));

		    
		    Map<String, String> erreurs =ProduitValidator.validate(p.getNom(), p.getDescription(), prixStr, stockStr);
		   
		    if (!erreurs.isEmpty()) {
		        request.setAttribute("erreurs", erreurs);
		        request.setAttribute("produit", p);
		        request.getRequestDispatcher("/WEB-INF/views/produits/form.jsp").forward(request, response);
		        return;
		    }
		    boolean Prduitcreation = (p.getId() == null);
		    dao.save(p);
		    FlashMessage.set(session,  Prduitcreation ? "Produit cree" : "Produit modifie");
		    response.sendRedirect(request.getContextPath() + "/Produits");
		}
		    
		
		
		
		
		
	
		
	

}
