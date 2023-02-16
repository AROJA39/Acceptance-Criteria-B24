package co.com.msacceptancecriteria.objects;

import org.json.JSONObject;

import co.com.msacceptancecriteria.constants.Constants;

/**
 * Class defining the method for tracking consumed operations.
 * 
 * @author Migration Team
 */
public class TrackingAcceptanceCriterial {
	
	public static JSONObject processTransaction = new JSONObject();

	/**
	 * Control method for monitoring consumed operations
	 * 
	 * @author Migration Team
	 * @param JSONObject
	 * @return JSONObject
	 *
	 */
	public JSONObject getInfoAcceptance(JSONObject infoacceptancriterial) {
		processTransaction = new JSONObject();
		Long initialTime = System.nanoTime();
		processTransaction = infoacceptancriterial;
		processTransaction = processTransaction(infoacceptancriterial);
		processTransaction.put("VERSION", Constants.VERSION);
		processTransaction.put("SERVICE", Constants.SERVICIO);
		processTransaction.put("PACKAGE", Constants.PAQUETE);
		processTransaction.put("CLASS", Constants.CLASE);
		processTransaction.put("ENDPOINT", Constants.ENDPOINT);
		processTransaction.put("TIME", (System.nanoTime() - initialTime) + " Nanoseconds");
		return processTransaction;
	}

	public JSONObject processTransaction(JSONObject infoacceptancriterial) {
		processTransaction.put(Constants.SUCCTRAN, infoacceptancriterial.get(Constants.STATUS).equals(Constants.SUCCESS) 
				? Counter.totalSuccess.incrementAndGet() : Counter.totalSuccess.get());
		processTransaction.put(Constants.FAILTRAN, infoacceptancriterial.get(Constants.STATUS).equals(Constants.FAILED) 
				? Counter.totalFailed.incrementAndGet() : Counter.totalFailed.get());
		processTransaction.put(Constants.TOTALTRAN, Counter.totalProcess.incrementAndGet());
		return processTransaction;

	}
}
