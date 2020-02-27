

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addArticle")
public class addArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/jsp/addArticle.jsp";
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
		List<Article> listArticle;

		
		//Ajout d'article quand on click sur le bouton
		if (request.getParameter("btAdd") != null) {
			boolean articleExist = false;
			String libelleArticle = request.getParameter(libelleForm);
			String referenceArticle = request.getParameter(referenceForm);
			int prixHTArticle = Integer.parseInt(request.getParameter(prixHTForm));
			int TVAArticle = Integer.parseInt(request.getParameter(TVAForm));
			long CodeBarreArticle = Long.parseLong(request.getParameter(CodeBarreForm));
			if(this.getServletContext().getAttribute("listArticle") != null) {
				listArticle = (List<Article>) this.getServletContext().getAttribute("listArticle");
			for(Article article : listArticle) {
				if(article.codeBarre == CodeBarreArticle) {
					articleExist = true;
					break;
				}
			}
			}else {
				listArticle = new ArrayList<Article>();
			}
			if(articleExist == false) {
 		    listArticle.add(new Article(CodeBarreArticle,referenceArticle, libelleArticle, prixHTArticle, TVAArticle));
 		    this.getServletContext().setAttribute("listArticle", listArticle);
 			this.getServletContext().getRequestDispatcher( "/listArticle" ).forward( request, response );

			}
			else {
				request.setAttribute("er", "Erreur, il y a déja un article avec ce code barre");
	 			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
			}

			
		}
		
		
	}

}
