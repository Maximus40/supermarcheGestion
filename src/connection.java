

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class connection
 */
@WebServlet("/connection")
public class connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/jsp/connection.jsp";
	public static final String nomUserForm = "inputUserName";
	public static final String mdpUserForm = "inputUserPasswd";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btCo") != null) {
			List<User> listUser = (List<User>) this.getServletContext().getAttribute("listUser");
			String inputNom = request.getParameter(nomUserForm);
			String inputPasswd = request.getParameter(mdpUserForm);
			boolean connectionReussi=false;
			
			for(User user : listUser) {
				if(inputNom.equals(user.nom)) {
					if(inputPasswd.equals(user.mdp)) {
						connectionReussi=true;
						break;
					}else {
						connectionReussi = false;
					}
				}else {
					connectionReussi = false;
				}
			}
			if(connectionReussi==true) {
				request.getSession().setAttribute("User", inputNom);
				this.getServletContext().getRequestDispatcher( "/listArticle" ).forward( request, response);
			}else {
				request.setAttribute("erCo", "Erreur, Nom ou mot de passe incorrect");
				doGet(request, response);
			}
		}

		
		
	}

}
