package dao;

import java.util.List;

import metier.entities.Produit;

public class testDAO {
public static void main(String[] args) {
	IProduitDAO dao = new ProduitDaoImpl();
	Produit p1 = dao.save(new Produit("MAC",7500.5,10));
	Produit p2 = dao.save(new Produit("IPhone",8500,10));
	Produit p3 = dao.save(new Produit("RTX 2080 TI",10000,10));
	System.out.println(p1.toString());
	System.out.println(p2.toString());
	System.out.println(p3.toString());
	
	System.out.println("************Rechercher tous les produits avec un mot clé**************");
	List<Produit> produits = dao.findAllByKeyword("MAC");
	for(Produit p : produits) {
		System.out.println(p.toString());
		}
	
	System.out.println("************Supprimer un produit**************");
	dao.delete(5L);
	
	System.out.println("************Trouver un produit**************");
	Produit p4 = dao.findOne(1L);	
	System.out.println(p4.toString());
	
	System.out.println("************Modifier un produit**************");
	p4.setDesignation("VILLA");
	dao.update(p4);
	System.out.println(p4.toString());
	
}
}
