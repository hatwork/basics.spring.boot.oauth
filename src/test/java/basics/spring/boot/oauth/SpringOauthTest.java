package basics.spring.boot.oauth;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpringOauthTest {

	public static final String REST_SERVICE_URI = "http://localhost:8083";

	public static void main(String[] args) {

		String token = getToken();
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<List> response = restTemplate.exchange(
				REST_SERVICE_URI + "/users/user/?access_token=" + token, HttpMethod.GET, request,
				List.class);
		List<LinkedHashMap<String, Object>> usersMap = (List<LinkedHashMap<String, Object>>) response.getBody();

		if (usersMap != null) {
			for (LinkedHashMap<String, Object> m : usersMap) {
				System.out.println("User : id=" + m.get("id") + ", Name=" + m.get("username") + ", Age=" + m.get("age")
						+ ", Salary=" + m.get("salary"));
				;
			}
		} else {
			System.out.println("No user exist----------");
		}
	}

	private static String getToken() {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> request = new HttpEntity<String>(getHeadersWithClientCredentials());
		ResponseEntity<Object> response = restTemplate.exchange(
				REST_SERVICE_URI + "/oauth/token?grant_type=password&username=hatim&password=hatim", HttpMethod.POST,
				request, Object.class);

		System.out.println(response.getBody());

		LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getBody();

		System.out.printf("Access Token: %s, Refresh Token: %s, Token Type: %s, Expires In: %s, Scope: %s",
				map.get("access_token"), map.get("refresh_token"), map.get("token_type"), map.get("expires_in"),
				map.get("scope"));

		return (String)map.get("access_token");
	}

	/*
	 * Prepare HTTP Headers.
	 */
	private static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	/*
	 * Add HTTP Authorization header, using Basic-Authentication to send
	 * client-credentials.
	 */
	private static HttpHeaders getHeadersWithClientCredentials() {
		String plainClientCredentials = "CLIENT-ID:SECRET";
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));

		HttpHeaders headers = getHeaders();
		headers.add("Authorization", "Basic " + base64ClientCredentials);
		return headers;
	}

}
