package businesslogic.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.servlets.handler.ServletHandler;
import businesslogic.servlets.handler.strategiesinstances.Strategies;

/**
 * Servlet implementation class MediatoreHandler
 */
public class MediatoreHandler extends HttpServlet {
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
    public MediatoreHandler() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		/*
		 * Send unapproved services to mediatore legale
		 */
		if(request.getParameter("op").equals("mediatore")) 
			ServletHandler.handle(Strategies.getInstance().getSendUnapprovedServiceToMediatoreStrategy(), request, response);
		
		/*
		 * Approvation request of a service by mediatore legale
		 */
		else if(request.getParameter("op").equals("approvation"))
			ServletHandler.handle(Strategies.getInstance().getApproveServiceByServiceCodeStrategy(), request, response);
		
	}

}
