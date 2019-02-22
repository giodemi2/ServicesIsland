package businesslogic.servlets;


import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businesslogic.servlets.handler.ServletHandler;
import businesslogic.servlets.handler.strategiesinstances.Strategies;


/**
 * Servlet implementation class UserHandler
 */
public class UserHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Load postgre driver
	 */
	static {
	    try {
	      Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	      System.err.println("PostgreSQL DataSource unable to load PostgreSQL JDBC Driver");
	    }
	 }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHandler() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*
		 * Logout operation
		 */
		if(request.getParameter("op").equals("logout")) 			
			ServletHandler.handle(Strategies.getInstance().getLogoutStrategy(), request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		/*
		 * Login operation
		 */
		if(request.getParameter("op").equals("login"))
			ServletHandler.handle(Strategies.getInstance().getLoginStrategy(), request, response);

		/*
		 * User registration operation
		 */
		else if(request.getParameter("op").equals("registerUser")) 		
			ServletHandler.handle(Strategies.getInstance().getUserRegistrationStrategy(), request, response);
		
		/*
		 * Professionist registration operation
		 */
		else if(request.getParameter("op").equals("registerProfessonist")) 			
			ServletHandler.handle(Strategies.getInstance().getProfessionistRegistrationStrategy(), request, response);
		
		/*
		 * Professionist account edit 
		 */
		else if(request.getParameter("op").equals("editProfessonist")) 			
			ServletHandler.handle(Strategies.getInstance().getEditProfessionistStrategy(), request, response);
		
		/*
		 * User account edit 
		 */
		else if(request.getParameter("op").equals("editUser")) 			
			ServletHandler.handle(Strategies.getInstance().getEditUserStrategy(), request, response);

		/*
		 * User account delete 
		 */
		else if(request.getParameter("op").equals("accountDelete")) 			
			ServletHandler.handle(Strategies.getInstance().getAccountDeleteStrategy(), request, response);

		
	
	}

}
