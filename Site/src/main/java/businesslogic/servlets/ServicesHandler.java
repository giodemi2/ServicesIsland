package businesslogic.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.servlets.handler.ServletHandler;
import businesslogic.servlets.handler.strategiesinstances.Strategies;
import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Servizio;
import it.servicesisland.Persistence.DataSource;
import it.servicesisland.Persistence.ServizioDaoJDBC;

/**
 * Servlet implementation class ServicesHandler
 */
public class ServicesHandler extends HttpServlet {
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
    public ServicesHandler() {
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
		 * Search service operation request
		 */
		if(request.getParameter("op").equals("search"))
			ServletHandler.handle(Strategies.getInstance().getSearchStrategy(), request, response);
		
		/*
		 * View service by id operation request (after search)
		 */
		else if(request.getParameter("op").equals("findService"))
			ServletHandler.handle(Strategies.getInstance().getFindServiceByIdStrategy(), request, response);
		
		/*
		 * Delete a prenotation of a user
		 */
		else if(request.getParameter("op").equals("deletePrenotation"))
			ServletHandler.handle(Strategies.getInstance().getRemoveUserPrenotationStrategy(), request, response);
		
		/*
		 * Delete a service of a professionist
		 */
		else if(request.getParameter("op").equals("deleteService"))
			ServletHandler.handle(Strategies.getInstance().getDeleteServiceOfProfessionistStrategy(), request, response);

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		/*
		 * Add service operation
		 */
		if(request.getParameter("op").equals("addService")) 
			ServletHandler.handle(Strategies.getInstance().getAddNewServiceStrategy(), request, response);
		
		/*
		 * Get notification list of a user by id
		 */
		else if(request.getParameter("op").equals("notifications"))
			ServletHandler.handle(Strategies.getInstance().getGetListOfUserNotificationsStrategy(), request, response);
		
		
		/*
		 * Make a service prenotation
		 */
		else if(request.getParameter("op").equals("prenotation"))
			ServletHandler.handle(Strategies.getInstance().getMakeServicePrenotationStrategy(), request, response);
		
		/*
		 * Get the list of all prenotations by user id
		 */
		else if(request.getParameter("op").equals("getPrenotations"))
			ServletHandler.handle(Strategies.getInstance().getViewUserPrenotationsStrategy(), request, response);
		
		/*
		 * Get the list of all prenotations for each service offered by a professionist 
		 */
		else if(request.getParameter("op").equals("getPrenotationsOfProfessionist"))
			ServletHandler.handle(Strategies.getInstance().getPrenotationOfAllServicesOfProfessionistStrategy(), request, response);
		
		/*
		 * Get the list of all services by user id
		 */
		else if(request.getParameter("op").equals("getServices"))
			ServletHandler.handle(Strategies.getInstance().getViewUserServicesStrategy(), request, response);
		
		/*
		 * Get statistic data
		 */
		else if (request.getParameter("op").equals("getStatistics"))
			ServletHandler.handle(Strategies.getInstance().getGetStatisticsStrategy(), request, response);
		

	}

}
