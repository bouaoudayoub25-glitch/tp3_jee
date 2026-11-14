package ma.app.util;

import java.math.BigDecimal;

import jakarta.servlet.http.HttpServletRequest;

import ma.app.model.Produit;

public class ProduitMapper {
	
	public static String clean(String s) {
        return (s == null) ? "" : s.trim();
    }

	public static Produit fromRequest(HttpServletRequest request) {
		
		  String idStr = clean(request.getParameter("id"));
	      String prixStr = clean(request.getParameter("prix")).replace(',', '.');
	      String stockStr = clean(request.getParameter("stock"));

	      Produit p = new Produit();
	      p.setNom(clean(request.getParameter("nom")));
	      p.setDescription(clean(request.getParameter("description")));
	      
	      try {
	            p.setId(idStr.isEmpty() ? null : Long.parseLong(idStr));
	        } catch (NumberFormatException e) {p.setId(null);}

	       
	        try {
	            p.setPrix(prixStr.isEmpty() ? null : new BigDecimal(prixStr));
	        } catch (NumberFormatException e) { p.setPrix(null);}

	        
	        try { 
	        	p.setStock(stockStr.isEmpty() ? 0 : Integer.parseInt(stockStr));
	        } catch (NumberFormatException e) {
	            p.setStock(0);
	        }

	        return p;
	        }
	    }
		
		
		
		
	
	

