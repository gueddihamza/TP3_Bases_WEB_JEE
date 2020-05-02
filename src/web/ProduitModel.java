package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Produit;
public class ProduitModel {
	private String keyword;
	private List<Produit> produits = new ArrayList<Produit>();	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}
