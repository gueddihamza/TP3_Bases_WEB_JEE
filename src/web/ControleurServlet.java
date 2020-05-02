package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.IProduitDAO;
import dao.ProduitDaoImpl;
import metier.entities.Produit;
@WebServlet(name = "cs" , urlPatterns = {"*.php"})
public class ControleurServlet extends HttpServlet {
	private IProduitDAO metier;
	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImpl();
	} 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if(path.equals("/index.php")) {
			req.getRequestDispatcher("produits.jsp").forward(req, resp);
		}
		else if(path.equals("/chercher.php")) {
			String keyword = req.getParameter("keyword");
			ProduitModel model = new ProduitModel();
			model.setKeyword(keyword);
			model.setProduits(metier.findAllByKeyword("%"+keyword+"%"));
			req.setAttribute("model", model);
			req.getRequestDispatcher("produits.jsp").forward(req, resp);
		}
		else if(path.equals("/saisie.php")) {
			req.getRequestDispatcher("saisie.jsp").forward(req, resp);
		}
		else if(path.equals("/confirmationsaisie.php")&& req.getMethod().equals("POST")) {
			String des = req.getParameter("des");
			double price = Double.parseDouble(req.getParameter("price"));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			Produit p = metier.save(new Produit(des,price,quantity));
			req.setAttribute("produit", p);
			req.getRequestDispatcher("confirmationsaisie.jsp").forward(req, resp);
		}
		
		else if(path.equals("/edit.php")) {
			Long id = Long.parseLong(req.getParameter("id"));
			Produit p = metier.findOne(id);
			req.setAttribute("produit", p);
			req.getRequestDispatcher("edit.jsp").forward(req,resp);		
			}
		else if(path.equals("/confirme.php")) {
			Long id = Long.parseLong(req.getParameter("id"));
			String designation = req.getParameter("des");
			double prix =Double.parseDouble( req.getParameter("price"));
			int quantite = Integer.parseInt(req.getParameter("quantity"));
			Produit p =metier.update(new Produit(id,designation,prix,quantite));
			resp.sendRedirect("chercher.php?keyword=");
			
		}
		else if (path.equals("/delete.php")) {
			Long id = Long.parseLong(req.getParameter("id"));
			metier.delete(id);
			resp.sendRedirect("chercher.php?keyword=");
			
			
		}
		else {
			resp.sendError(org.apache.catalina.connector.Response.SC_NOT_FOUND);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
	}

}
