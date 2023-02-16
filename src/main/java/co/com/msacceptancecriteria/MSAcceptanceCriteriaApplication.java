package co.com.msacceptancecriteria;

import co.com.msacceptancecriteria.constants.Constants;
import co.com.msacceptancecriteria.handler.get;
import io.javalin.Javalin;
import io.javalin.http.HttpCode;

/**
 * Main class in charge of service initialization
 * @author Migration Team
 */
public class MSAcceptanceCriteriaApplication {

	/**
     * Method to manage the configuration of the initialization port and redirection to the handler class.
     * 
     * @author Migration Team
     * @param Context
     * @throws Exception
     *
     */
	public static void main(String[] args) {
		try {
			Javalin app = Javalin.create().start(Constants.SERVERPORT);
			app.get("/acceptanceCriteria", new get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
