package dao;

import java.util.List;

import metier.entities.Produit;

public interface IProduitDAO {
	public Produit save(Produit p);
	public List<Produit> findAllByKeyword(String keyword);
	public void delete(Long id);
	public Produit findOne(Long id);
	public Produit update(Produit p);
	
}
