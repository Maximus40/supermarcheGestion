

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class panier
 */
@WebServlet("/panier")
public class panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/jsp/panier.jsp";
	public static final String CodeBarreForm = "inputCBPanier";

       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Article> listPanier = (List<Article>) request.getSession().getAttribute("listPanier");
		
		//Calcul du prix total TTC et du total TVA
		if(listPanier != null) {
			log(request.getSession().getAttribute("listPanier").toString());
		 int totalTTC=0;
		 int totalTVA=0;
         for(int i =0 ; i < listPanier.size(); i++) {
          int prixTVA = listPanier.get(i).prixHT * listPanier.get(i).tauxTVA/100;
      	  int prixTTC = listPanier.get(i).prixHT + prixTVA;
      	  
      	  totalTVA += prixTVA;
      	  totalTTC += prixTTC;
         }
			request.setAttribute("totalTVA", totalTVA);
			request.setAttribute("totalTTC", totalTTC);
		}
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> listArticle = (List<Article>) this.getServletContext().getAttribute("listArticle");
		boolean itemAjouter = false;
		List<Article> listPanier;
		
		//Ajout d'article dans le panier quand on click sur le bouton
		if (request.getParameter("btAddPanier") != null) {
			long CodeBarreArticlePanier = Long.parseLong(request.getParameter(CodeBarreForm));
			if(request.getSession().getAttribute("listPanier") != null) {
				listPanier = (List<Article>) request.getSession().getAttribute("listPanier");
			}else{
				listPanier = new ArrayList<Article>();
			}
			if(this.getServletContext().getAttribute("listArticle") != null) {
				for(Article article : listArticle) {
					if(article.codeBarre == CodeBarreArticlePanier) {
						listPanier.add(article);
						itemAjouter = true;
						request.getSession().setAttribute("listPanier", listPanier);
						break;
					}
					else {
						itemAjouter = false;
					}
				}
		}
				if(itemAjouter != true) {
						request.setAttribute("erPanier", "Il n'y a pas d'article avec ce code barre");
				}
			}
		
		//Suppression d'article dans le panier quand on click sur le bouton
		if (request.getParameter("btDeletePanier") != null) {
			listPanier = (List<Article>) request.getSession().getAttribute("listPanier");
           for(int i =0 ; i < listPanier.size(); i++) {
        	   if(Long.parseLong(request.getParameter("btDeletePanier")) == listPanier.get(i).codeBarre) {
        		   listPanier.remove(listPanier.get(i));   
        	   }
           }
           if(listPanier.size() == 0) {
        	   listPanier = null;
           }
           request.getSession().setAttribute("listPanier", listPanier);
		}
			doGet(request, response);

	}
}

	


