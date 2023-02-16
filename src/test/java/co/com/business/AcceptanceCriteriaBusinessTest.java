package co.com.business;

import java.util.HashMap;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import co.com.msacceptancecriteria.business.AcceptanceCriteriaBusiness;
import co.com.msacceptancecriteria.constants.Constants;

class AcceptanceCriteriaBusinessTest {

	AcceptanceCriteriaBusiness business = new AcceptanceCriteriaBusiness();

	@Test
	void TestSuccessfulRequestSubmission02() {
		HashMap<String, String> request = new HashMap<>();
		request.put(Constants.RULEREQUEST, "02");
		String text = "{\"FIELD_52-1\":\"^[F]{16}$\",\"FIELD_41-7\":\"^(.){13}[0]{3}.*$\",\"FIELD_41-6\":\"^(.){12}7.*$\",\"FIELD_22-1\":\"^051$\",\"FIELD_41-4\":\"^(.){8}[0]{4}.*$\",\"FIELD_41-3\":\"^(.){4}\\\\d{4}.*$\",\"FIELD_41-1\":\"^0001.*$\",\"FIELD_102-1\":\"^[0]*$\",\"FIELD_103-1\":\"^0.*$\",\"FIELD_103-4\":\"^(.){2}0.*$\",\"FIELD_104-1\":\"^\\\\d{12}.*$\",\"FIELD_103-3\":\"^(.){1}1.*$\",\"FIELD_104-2\":\"^(.){12}\\\\d{12}.*$\",\"FIELD_103-8\":\"^(.){7}\\\\d{17}.*$\",\"FIELD_103-7\":\"^(.){3}00(01|02|23|52).*$\",\"FIELD_35-9\":\"^(.){32}[0]{5}.*$\",\"FIELD_35-8\":\"^(.){29}(\\\\d){3}.*$\",\"FIELD_48-1\":\"^0001.*$\",\"FIELD_35-7\":\"^(.){24}[0]{5}.*$\",\"FIELD_35-6\":\"^(.){21}(\\\\d){3}.*$\",\"FIELD_48-3\":\"^(.){4}[0]{8}.*$\",\"FIELD_35-5\":\"^(.){17}\\\\d{4}.*$\",\"FIELD_48-4\":\"^(.){12}[12].*$\",\"FIELD_35-4\":\"^(.){16}[D=].*$\",\"FIELD_48-5\":\"^(.){13}[0]{24}.*$\",\"FIELD_35-3\":\"^(.){6}(\\\\d){10}.*$\",\"FIELD_48-6\":\"^(.){37}\\\\d{7}.*$\",\"FIELD_35-1\":\"^491511.*$\",\"FIELD_32-1\":\"^10000000001$\"}";
		JSONObject response = new JSONObject(text) ;
		Assertions.assertEquals(response.toString(), business.extraccionAcceptanceCriteria(request).toString());
	}

	@Test
	void TestSuccessfulRequestSubmission03() {
		HashMap<String, String> request = new HashMap<>();
		request.put(Constants.RULEREQUEST, "03");
		String text = "{\"FIELD_52-1\":\"^[F]{16}$\",\"FIELD_41-7\":\"^(.){13}[0]{3}.*$\",\"FIELD_41-6\":\"^(.){12}7.*$\",\"FIELD_22-2\":\"^0(2|5)1$\",\"FIELD_41-4\":\"^(.){8}[0]{4}.*$\",\"FIELD_41-3\":\"^(.){4}\\\\d{4}.*$\",\"FIELD_41-2\":\"^00(02|23|52).*$\",\"FIELD_102-1\":\"^[0]*$\",\"FIELD_103-1\":\"^0.*$\",\"FIELD_103-5\":\"^(.){2}1.*$\",\"FIELD_104-1\":\"^\\\\d{12}.*$\",\"FIELD_103-3\":\"^(.){1}1.*$\",\"FIELD_104-2\":\"^(.){12}\\\\d{12}.*$\",\"FIELD_103-8\":\"^(.){7}\\\\d{17}.*$\",\"FIELD_103-7\":\"^(.){3}00(01|02|23|52).*$\",\"FIELD_35-9\":\"^(.){32}[0]{5}.*$\",\"FIELD_35-8\":\"^(.){29}(\\\\d){3}.*$\",\"FIELD_35-7\":\"^(.){24}[0]{5}.*$\",\"FIELD_48-2\":\"^00(02|23|52).*$\",\"FIELD_35-6\":\"^(.){21}(\\\\d){3}.*$\",\"FIELD_48-3\":\"^(.){4}[0]{8}.*$\",\"FIELD_35-5\":\"^(.){17}\\\\d{4}.*$\",\"FIELD_48-4\":\"^(.){12}[12].*$\",\"FIELD_35-4\":\"^(.){16}[D=].*$\",\"FIELD_48-5\":\"^(.){13}[0]{24}.*$\",\"FIELD_35-3\":\"^(.){6}(\\\\d){10}.*$\",\"FIELD_48-6\":\"^(.){37}\\\\d{7}.*$\",\"FIELD_35-2\":\"^\\\\d{6}.*$\",\"FIELD_32-2\":\"^100000000(02|23|52)$\"}";
		JSONObject response = new JSONObject(text) ;
		Assertions.assertEquals(response.toString(), business.extraccionAcceptanceCriteria(request).toString());
	}

	@Test
	void TestSuccessfulRequestSubmission47() {
		HashMap<String, String> request = new HashMap<>();
		request.put(Constants.RULEREQUEST, "47");
		String text = "{\"FIELD_60-1\":\"^VISAVISA-300$\",\"FIELD_52-2\":\"\",\"FIELD_48-16\":\"^[0]{26}.*$\",\"FIELD_57-1\":\"^.*$\",\"FIELD_35-4\":\"^(.){16}[D=].*$\",\"FIELD_32-6\":\"^12345678901$\",\"FIELD_22-1\":\"^051$\",\"FIELD_35-11\":\"^(.){17}9999.*$\",\"FIELD_41-11\":\"^TERMID02$\",\"FIELD_35-12\":\"^(.){21}000.*$\",\"FIELD_35-13\":\"^(.){24}[0]{5}.*$\",\"FIELD_35-14\":\"^(.){29}000.*$\",\"FIELD_35-15\":\"^(.){32}[0]{5}.*$\",\"FIELD_35-17\":\"^777760.*$\",\"FIELD_35-18\":\"^(.){6}(0){10}.*$\",\"FIELD_35-19\":\"^(.){17}0000.*$\"}";
		JSONObject response = new JSONObject(text) ;
		Assertions.assertEquals(response.toString(), business.extraccionAcceptanceCriteria(request).toString());
	}

	@Test
	void TestSuccessfulRequestSubmissionmal01() {
		HashMap<String, String> request = new HashMap<>();
		request.put(Constants.RULEREQUEST, "01");
		String text = "{\"STATUS\":\"FAILED\",\"ERROR\":\"Information not found\"}";
		JSONObject response = new JSONObject(text) ;
		Assertions.assertEquals(response.toString(), business.extraccionAcceptanceCriteria(request).toString());
	}
	@Test
	void TestSuccessfulRequestSubmission39() {
		HashMap<String, String> request = new HashMap<>();
		request.put(Constants.RULEREQUEST, "39");
		String text = "{\"FIELD_52-1\":\"^[F]{16}$\",\"FIELD_41-8\":\"^0054.*$\",\"FIELD_41-7\":\"^(.){13}[0]{3}.*$\",\"FIELD_41-5\":\"^(.){12}1.*$\",\"FIELD_22-1\":\"^051$\",\"FIELD_41-4\":\"^(.){8}[0]{4}.*$\",\"FIELD_41-3\":\"^(.){4}\\\\d{4}.*$\",\"FIELD_103-12\":\"^(.){1}0001.*$\",\"FIELD_103-15\":\"^(.){9}0.*$\",\"FIELD_103-16\":\"^(.){10}\\\\d{8}.*$\",\"FIELD_103-17\":\"^(.){5}0001.*$\",\"FIELD_104-3\":\"^(0){16}$\",\"FIELD_104-4\":\"^(.){16}\\\\d{2}.*$\",\"FIELD_103-9\":\"^0.*$\",\"FIELD_35-9\":\"^(.){32}[0]{5}.*$\",\"FIELD_35-8\":\"^(.){29}(\\\\d){3}.*$\",\"FIELD_48-1\":\"^0001.*$\",\"FIELD_35-7\":\"^(.){24}[0]{5}.*$\",\"FIELD_35-6\":\"^(.){21}(\\\\d){3}.*$\",\"FIELD_48-3\":\"^(.){4}[0]{8}.*$\",\"FIELD_35-5\":\"^(.){17}\\\\d{4}.*$\",\"FIELD_48-4\":\"^(.){12}[12].*$\",\"FIELD_35-4\":\"^(.){16}[D=].*$\",\"FIELD_48-5\":\"^(.){13}[0]{24}.*$\",\"FIELD_35-3\":\"^(.){6}(\\\\d){10}.*$\",\"FIELD_48-6\":\"^(.){37}\\\\d{7}.*$\",\"FIELD_35-2\":\"^\\\\d{6}.*$\",\"FIELD_32-3\":\"^10000000054$\"}";
		JSONObject response = new JSONObject(text) ;
		Assertions.assertEquals(response.toString(), business.extraccionAcceptanceCriteria(request).toString());
	}

}
