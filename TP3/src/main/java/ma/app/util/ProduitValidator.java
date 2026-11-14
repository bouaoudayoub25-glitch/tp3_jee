package ma.app.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProduitValidator {
	public static Map<String, String> validate(String nom, String description,String prixStr, String stockStr){
		
		Map<String, String> erreurs = new HashMap<>();
		
		    if (nom.length() < 2 || nom.length() > 50) erreurs.put("nom", "Le nom est obligatoire (2 a 50 caracteres)");
		  

		    BigDecimal prix = null;
		    if (prixStr.isEmpty()) {
		        erreurs.put("prix", "Le prix est obligatoire");
		    } else {
		        try {
		            prix = new BigDecimal(prixStr);
		            if (prix.signum() <= 0) {
		                erreurs.put("prix", "Le prix doit etre strictement positif");
		            }
		        } catch (NumberFormatException e) {
		            erreurs.put("prix", "Prix invalide");
		        }
		    }
		
		    int stock = 0; 
		    if (!stockStr.isEmpty()) {
		        try {
		            stock = Integer.parseInt(stockStr);
		            if (stock < 0) {
		                erreurs.put("stock", "Le stock doit etre >= 0");
		            }
		        } catch (NumberFormatException e) {
		            erreurs.put("stock", "Stock invalide (entier attendu)");
		        }
		    }

		    if (description.length() > 255) {
		        erreurs.put("description", "255 caracteres maximum");
		    }
		    return erreurs;
	}
	
	
	
}
