package co.com.msacceptancecriteria.business;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONObject;
import co.com.msacceptancecriteria.constants.Constants;
import co.com.msacceptancecriteria.objects.TrackingAcceptanceCriterial;
import co.com.msacceptancecriteria.support.ClientFileUpload;

/**
 * Class handles logic for transaction acceptance criteria
 * 
 * @author Migration Team
 */
public class AcceptanceCriteriaBusiness {

	public static JSONObject tracking = null;
	public static JSONObject jsonResponse = null;

	/**
	 * Invoking the method to consume the file service
	 * 
	 * @author Migration Team
	 * @param String
	 * @return ConcurrentHasMap
	 */
	public static ConcurrentHashMap<String, String> acceptanceCriterial = (ConcurrentHashMap<String, String>) new ClientFileUpload()
			.getDataFile(Constants.ACCEPTANCECRITERIAL);
	public static ConcurrentHashMap<String, String> regularExpresion = (ConcurrentHashMap<String, String>) new ClientFileUpload()
			.getDataFile(Constants.REGULAREXPRESION);
	public static ConcurrentHashMap<String, String> cacheInformation = new ConcurrentHashMap<>();

	/**
	 * Method of control for the identification of the acceptance criteria for
	 * transactions
	 * 
	 * @author Migration Team
	 * @param HasMap<String, String>
	 * @return String
	 *
	 */
	public String getOperation(HashMap<String, String> request) throws Exception {
		jsonResponse = new JSONObject();
		if (Objects.isNull(acceptanceCriterial) || Objects.isNull(regularExpresion)) {
			jsonResponse.put(Constants.ERROR, "Los componentes no están completos para procesar la información.");
			jsonResponse.put(Constants.STATUS, Constants.FAILED);
			jsonResponse = new TrackingAcceptanceCriterial().getInfoAcceptance(jsonResponse);
			return jsonResponse.toString();
		}
		if (request.containsKey(Constants.RULEREQUEST)) {
			if (cacheInformation.get(request.get(Constants.RULEREQUEST)) != null) {
				String response = cacheInformation.get(request.get(Constants.RULEREQUEST));
				jsonResponse = new JSONObject(response);
			}
			jsonResponse = (JSONObject) extraccionAcceptanceCriteria(request);
		} else if (request.containsKey(Constants.STATUS)) {
			jsonResponse = new TrackingAcceptanceCriterial().getInfoAcceptance(tracking);
		} else {
			jsonResponse.put(Constants.ERROR, Constants.OPERATION_NOT_FOUND);
			jsonResponse.put(Constants.STATUS, Constants.FAILED);
			jsonResponse = new TrackingAcceptanceCriterial().getInfoAcceptance(jsonResponse);

		}
		return jsonResponse.toString();

	}

	public JSONObject extraccionAcceptanceCriteria(HashMap<String, String> request) {
		JSONObject responseInfo = new JSONObject();
		String rule = request.get(Constants.RULEREQUEST);
		tracking = new JSONObject();
		if (acceptanceCriterial.containsKey(rule)) {
			String acceptanCriterial = acceptanceCriterial.get(rule);
			String[] criteria = acceptanCriterial.split(Constants.SEPARATOR);
			for (String criterion : criteria) {
				if (regularExpresion.containsKey(criterion)) {
					responseInfo.put(Constants.RESPONSEFIELD + criterion, regularExpresion.get(criterion));
				}
			}
			tracking.put(Constants.STATUS, Constants.SUCCESS);
			cacheInformation.put(rule, responseInfo.toString());
			return responseInfo;
		} else {
			responseInfo.put(Constants.STATUS, Constants.FAILED);
			responseInfo.put(Constants.ERROR, Constants.DESERROR);
			tracking = responseInfo;
			return tracking;
		}
	}

}
