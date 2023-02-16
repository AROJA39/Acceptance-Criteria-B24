package co.com.msacceptancecriteria.support;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;

import co.com.msacceptancecriteria.constants.Constants;

/**
 * Class in charge of calling the file upload service.
 * 
 * @author Migration Team
 */
public class ClientFileUpload {

	/**
	 * Control method for file uploading service consumption
	 * 
	 * @author Migration Team
	 * @param String
	 * @return ConcurrentHasMap<String, String>
	 * @throws Exception
	 *
	 */
	public ConcurrentHashMap<String, String> getDataFile(String file) {
		ConcurrentHashMap<String, String> dataFile = null;
		try {
			StringBuilder resultado = new StringBuilder();
			URL url = new URL(Constants.ENDPOINTUPLOADFILE + file);
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");
			conexion.setConnectTimeout(2000);
			BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String linea;
			while ((linea = reader.readLine()) != null) {
				resultado.append(linea);
			}
			reader.close();
			dataFile = new Gson().fromJson(resultado.toString(), ConcurrentHashMap.class);
			return dataFile;
		} catch (Exception e) {
			return dataFile;
		}

		
	}

}
