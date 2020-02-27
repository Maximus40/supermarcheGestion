import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public final class listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
    	
    	//Ajout de quelques articles et utilisateurs au lancement de l'application
        ServletContext context = event.getServletContext();
    	List<Article> listArticle = new ArrayList<Article>();
    	List<User> listUser = new ArrayList<User>();

		long longart1 = 555555;
		long longart2= 12345;
		Article art1 = new Article(longart1, "referenceArt1", "libelleArt1", 20, 15);
		Article art2 = new Article(longart2, "referenceArt2", "libelleArt2", 10, 20);
		listArticle.add(art1);
		listArticle.add(art2);
		
		User user1 = new User("nom1", "mdp1");
		User user2 = new User("nom2", "mdp2");
		listUser.add(user1);
		listUser.add(user2);
		
		
		context.setAttribute("listUser", listUser);
		context.setAttribute("listArticle", listArticle);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        //Nothing to do
    }
}