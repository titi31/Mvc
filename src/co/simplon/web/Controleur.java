package co.simplon.web;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpSessionEvent;
/**
 * Servlet implementation class Controleur
 */
@WebServlet(urlPatterns="/controleur",loadOnStartup=1)
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static int counter=0;
	 private String databaseURL;
    /**
     * @see HttpServlet#HttpServlet()
     */
   /* public Controleur() {
        super();
        // TODO Auto-generated constructor stub
    }*/
    public void init() throws ServletException{
    	super.init();
    	databaseURL=this.getServletContext().getInitParameter("DATABASE_URL");
    	System.out.println("int url : "+databaseURL);
    	counter=0;
    }
	
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		if(login == null) login="";
		if(password==null) password="";
		HttpSession session=request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		request.getRequestDispatcher("/Vue.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		HttpSession session=request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		
		
		if(login.contentEquals("dark") && password.contentEquals("dodo")) {
			request.getRequestDispatcher("/Connected.jsp").forward(request, response);
			session.setAttribute("isConnected", true);
			counter++;
			System.out.println("in :"+counter);
			
		}else if(login.contentEquals("titi") && password.contentEquals("darki")) {
			request.getRequestDispatcher("/Connected.jsp").forward(request, response);
			session.setAttribute("isConnected", true);
			
		
		
		}
		else {
			request.getRequestDispatcher("/Vue.jsp").forward(request, response);
			session.setAttribute("isConnected", false);
		}
	}
	public void destroy() {
		System.out.println("je suis detruit");
		super.destroy();
	}

}
