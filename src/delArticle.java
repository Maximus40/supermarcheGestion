

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
@WebServlet("/delArticle")
public class delArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/jsp/delArticle.jsp";

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
		
		//Suppression d'article quand on click sur le bouton
		if (request.getParameter("btDelete") != null) {
           
           for(int i =0 ; i < listArticle.size(); i++) {
        	   if(Long.parseLong(request.getParameter("btDelete")) == listArticle.get(i).codeBarre) {
        		   
        		   listArticle.remove(listArticle.get(i));
        		   
        		   
        	   }
           }
           if(listArticle.size() == 0) {
        	   listArticle = null;
           }
		}
		this.getServletContext().setAttribute("listArticle", listArticle);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
   }

}
