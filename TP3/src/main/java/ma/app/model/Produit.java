package ma.app.model;
import java.math.BigDecimal;
public class Produit {
private Long id;
private String nom;
private String description;
private BigDecimal prix;
private int stock;
public Produit() {}
public Produit(Long id, String nom, String description, BigDecimal prix, int stock) {
this.id = id;
this.nom = nom;
this.description = description;
this.prix = prix;
this.stock = stock;

}

public void setId(Long id) {this.id=id;}
public void setNom(String nom){this.nom=nom;}
public void setDescription(String description) {this.description=description;}
public void setPrix(BigDecimal prix) {this.prix=prix;}
public void setStock(int stock) {this.stock=stock;}


public Long getId() {return this.id;}
public String getNom(){return this.nom;}
public String getDescription() {return this.description;}
public BigDecimal getPrix() {return this.prix;}
public int getStock() {return this.stock;}




}
// TODO : getters et setters pour tous les champs
// (indispensables : l'EL ${produit.nom} appelle getNom())