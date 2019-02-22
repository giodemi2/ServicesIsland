/**
 * 
 */
package businesslogic.servlets.handler.strategiesinstances;

import businesslogic.servlets.handler.AccountDeleteStrategy;
import businesslogic.servlets.handler.AddNewServiceStrategy;
import businesslogic.servlets.handler.ApproveServiceByServiceCodeStrategy;
import businesslogic.servlets.handler.DeleteServiceOfProfessionistStrategy;
import businesslogic.servlets.handler.EditProfessionistStrategy;
import businesslogic.servlets.handler.EditUserStrategy;
import businesslogic.servlets.handler.FindServiceByIdStrategy;
import businesslogic.servlets.handler.GetListOfUserNotificationsStrategy;
import businesslogic.servlets.handler.GetStatisticsStrategy;
import businesslogic.servlets.handler.LoginStrategy;
import businesslogic.servlets.handler.LogoutStrategy;
import businesslogic.servlets.handler.MakeServicePrenotationStrategy;
import businesslogic.servlets.handler.PrenotationOfAllServicesOfProfessionistStrategy;
import businesslogic.servlets.handler.ProfessionistRegistrationStrategy;
import businesslogic.servlets.handler.RemoveUserPrenotationStrategy;
import businesslogic.servlets.handler.SearchStrategy;
import businesslogic.servlets.handler.SendUnapprovedServiceToMediatoreStrategy;
import businesslogic.servlets.handler.UserRegistrationStrategy;
import businesslogic.servlets.handler.ViewUserPrenotationsStrategy;
import businesslogic.servlets.handler.ViewUserServicesStrategy;

/**
 * @author rodolfo
 * {@link Strategies} singleton class
 */
public class Strategies {

	/**
	 * Singleton instance
	 */
	private static Strategies instance;
	
	/**
	 * Strategies instances
	 */
	private AddNewServiceStrategy addNewServiceStrategy;
	private ApproveServiceByServiceCodeStrategy approveServiceByServiceCodeStrategy;
	private DeleteServiceOfProfessionistStrategy deleteServiceOfProfessionistStrategy;
	private FindServiceByIdStrategy findServiceByIdStrategy;
	private GetListOfUserNotificationsStrategy getListOfUserNotificationsStrategy;
	private MakeServicePrenotationStrategy makeServicePrenotationStrategy;
	private RemoveUserPrenotationStrategy removeUserPrenotationStrategy;
	private SearchStrategy searchStrategy;
	private SendUnapprovedServiceToMediatoreStrategy sendUnapprovedServiceToMediatoreStrategy;
	private ViewUserPrenotationsStrategy viewUserPrenotationsStrategy;
	private ViewUserServicesStrategy viewUserServicesStrategy;
	private LogoutStrategy logoutStrategy;
	private LoginStrategy loginStrategy;
	private UserRegistrationStrategy userRegistrationStrategy;
	private ProfessionistRegistrationStrategy professionistRegistrationStrategy;
	private PrenotationOfAllServicesOfProfessionistStrategy prenotationOfAllServicesOfProfessionistStrategy;
	private GetStatisticsStrategy getStatisticsStrategy;
	private EditUserStrategy editUserStrategy;
	private EditProfessionistStrategy editProfessionistStrategy;
	private AccountDeleteStrategy accountDeleteStrategy;
	
	/**
	 * Constructor without parameters
	 */
	public Strategies() {
		addNewServiceStrategy = new AddNewServiceStrategy();
		approveServiceByServiceCodeStrategy = new ApproveServiceByServiceCodeStrategy();
		deleteServiceOfProfessionistStrategy = new DeleteServiceOfProfessionistStrategy();
		findServiceByIdStrategy = new FindServiceByIdStrategy();
		getListOfUserNotificationsStrategy = new GetListOfUserNotificationsStrategy();
		makeServicePrenotationStrategy = new MakeServicePrenotationStrategy();
		removeUserPrenotationStrategy = new RemoveUserPrenotationStrategy();
		searchStrategy = new SearchStrategy();
		sendUnapprovedServiceToMediatoreStrategy = new SendUnapprovedServiceToMediatoreStrategy();
		viewUserPrenotationsStrategy = new ViewUserPrenotationsStrategy();
		viewUserServicesStrategy = new ViewUserServicesStrategy();
		logoutStrategy = new LogoutStrategy();
		loginStrategy = new LoginStrategy();
		userRegistrationStrategy = new UserRegistrationStrategy();
		professionistRegistrationStrategy = new ProfessionistRegistrationStrategy();
		prenotationOfAllServicesOfProfessionistStrategy = new PrenotationOfAllServicesOfProfessionistStrategy();
		getStatisticsStrategy = new GetStatisticsStrategy();
		editUserStrategy = new EditUserStrategy();
		editProfessionistStrategy = new EditProfessionistStrategy();
		accountDeleteStrategy = new AccountDeleteStrategy();
	}
	
	/**
	 * @return the single instance of {@link Strategies}
	 */
	public static Strategies getInstance() {
		if(instance == null) {
			instance = new Strategies();
		}
		return instance;
	}

	/**
	 * @return the addNewServiceStrategy
	 */
	public AddNewServiceStrategy getAddNewServiceStrategy() {
		return addNewServiceStrategy;
	}

	/**
	 * @return the approveServiceByServiceCodeStrategy
	 */
	public ApproveServiceByServiceCodeStrategy getApproveServiceByServiceCodeStrategy() {
		return approveServiceByServiceCodeStrategy;
	}

	/**
	 * @return the deleteServiceOfProfessionistStrategy
	 */
	public DeleteServiceOfProfessionistStrategy getDeleteServiceOfProfessionistStrategy() {
		return deleteServiceOfProfessionistStrategy;
	}

	/**
	 * @return the findServiceByIdStrategy
	 */
	public FindServiceByIdStrategy getFindServiceByIdStrategy() {
		return findServiceByIdStrategy;
	}

	/**
	 * @return the getListOfUserNotificationsStrategy
	 */
	public GetListOfUserNotificationsStrategy getGetListOfUserNotificationsStrategy() {
		return getListOfUserNotificationsStrategy;
	}

	/**
	 * @return the makeServicePrenotationStrategy
	 */
	public MakeServicePrenotationStrategy getMakeServicePrenotationStrategy() {
		return makeServicePrenotationStrategy;
	}

	/**
	 * @return the removeUserPrenotationStrategy
	 */
	public RemoveUserPrenotationStrategy getRemoveUserPrenotationStrategy() {
		return removeUserPrenotationStrategy;
	}

	/**
	 * @return the searchStrategy
	 */
	public SearchStrategy getSearchStrategy() {
		return searchStrategy;
	}

	/**
	 * @return the sendUnapprovedServiceToMediatoreStrategy
	 */
	public SendUnapprovedServiceToMediatoreStrategy getSendUnapprovedServiceToMediatoreStrategy() {
		return sendUnapprovedServiceToMediatoreStrategy;
	}

	/**
	 * @return the viewUserPrenotationsStrategy
	 */
	public ViewUserPrenotationsStrategy getViewUserPrenotationsStrategy() {
		return viewUserPrenotationsStrategy;
	}

	/**
	 * @return the viewUserServicesStrategy
	 */
	public ViewUserServicesStrategy getViewUserServicesStrategy() {
		return viewUserServicesStrategy;
	}

	/**
	 * @return the logoutStrategy
	 */
	public LogoutStrategy getLogoutStrategy() {
		return logoutStrategy;
	}

	/**
	 * @return the loginStrategy
	 */
	public LoginStrategy getLoginStrategy() {
		return loginStrategy;
	}

	/**
	 * @return the userRegistrationStrategy
	 */
	public UserRegistrationStrategy getUserRegistrationStrategy() {
		return userRegistrationStrategy;
	}

	/**
	 * @return the professionistRegistrationStrategy
	 */
	public ProfessionistRegistrationStrategy getProfessionistRegistrationStrategy() {
		return professionistRegistrationStrategy;
	}

	/**
	 * @return the prenotationOfAllServicesOfProfessionistStrategy
	 */
	public PrenotationOfAllServicesOfProfessionistStrategy getPrenotationOfAllServicesOfProfessionistStrategy() {
		return prenotationOfAllServicesOfProfessionistStrategy;
	}

	/**
	 * @return the getStatisticsStrategy
	 */
	public GetStatisticsStrategy getGetStatisticsStrategy() {
		return getStatisticsStrategy;
	}

	/**
	 * @return the editUserStrategy
	 */
	public EditUserStrategy getEditUserStrategy() {
		return editUserStrategy;
	}

	/**
	 * @return the editProfessionistStrategy
	 */
	public EditProfessionistStrategy getEditProfessionistStrategy() {
		return editProfessionistStrategy;
	}

	/**
	 * @return the accountDeleteStrategy
	 */
	public AccountDeleteStrategy getAccountDeleteStrategy() {
		return accountDeleteStrategy;
	}
	
	
}
