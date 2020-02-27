

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delArticle
 */
@WebServlet("/upArticle")
public class upArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/jsp/upArticle.jsp";
	public static final String referenceForm = "inputReference";
	public static final String libelleForm = "inputLibelle";
	public static final String prixHTForm = "inputPrixHT";
	public static final String TVAForm = "inputTVA";
	public static final String CodeBarreForm = "inputCB";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.getServletContext().getRequestDispatcher( VUE ).forward( req, resp );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Article> listArticle = (List<Article>) this.getServletContext().getAttribute("listArticle");
		
		//Selection de l'article a modifier quand on click sur le bouton "modifier"
		if (request.getParameter("btMod") != null) {
			 for(int i =0 ; i < listArticle.size(); i++) {
	        	   if(Long.parseLong(request.getParameter("btMod")) == listArticle.get(i).codeBarre) {
	        		   
	        		   request.getSession().setAttribute("modifArt", listArticle.get(i));
	        		   this.getServletContext().getRequestDispatcher( "/modifArticle" ).forward( request, response );
	        	   }
			 }
		}
		
		//Modification de l'article quand on click sur le bouton "valider"
		if (request.getParameter("btModif") != null) {
			
		boolean articleExist = false;
		String libelleArticle = request.getParameter(libelleForm);
		String referenceArticle = request.getParameter(referenceForm);
		int prixHTArticle = Integer.parseInt(request.getParameter(prixHTForm));
		int TVAArticle = Integer.parseInt(request.getParameter(TVAForm));
		long CodeBarreArticle = Long.parseLong(request.getParameter(CodeBarreForm));
		Article articleModifier =  (Article) request.getSession().getAttribute("modifArt");
		
		if(CodeBarreArticle != articleModifier.codeBarre) {
			for(Article article : listArticle) {
				if(article.codeBarre == CodeBarreArticle) {
					articleExist = true;
					break;
				}
			}
		}
		if(articleExist==false) {
		articleModifier.setReference(referenceArticle);
		articleModifier.setLibelle(libelleArticle);
		articleModifier.setPrixHT(prixHTArticle);
		articleModifier.setTauxTVA(TVAArticle);
		articleModifier.setCodeBarre(CodeBarreArticle);
		    
		    this.getServletContext().setAttribute("listArticle", listArticle);
			this.getServletContext().getRequestDispatcher( "/listArticle" ).forward( request, response );
		}
		else {
			request.setAttribute("erMod", "Erreur, il y a déja un article avec ce code barre");
 			this.getServletContext().getRequestDispatcher( "/modifArticle" ).forward( request, response );
		}
		}
	}
}