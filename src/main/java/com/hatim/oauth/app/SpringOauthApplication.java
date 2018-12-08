package com.hatim.oauth.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hatim.oauth")
public class SpringOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOauthApplication.class, args);
	}
	
//	public static final String REST_SERVICE_URI = "http://localhost:8083";
//	
//	@Bean
//	public CommandLineRunner demo() {
//		
//		return args -> {
//			
//			HttpHeaders headers = new HttpHeaders();
//	    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	    	
//	    	String plainClientCredentials="devglan-client:devglan-secret";
//	    	String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
//	    	
//	    	headers.add("Authorization", "Basic " + base64ClientCredentials);
//	    	
//	    	
//	    	RestTemplate restTemplate = new RestTemplate(); 
//	    	
//	    	HttpEntity<String> request = new HttpEntity<String>(headers);
//	        ResponseEntity<Object> response = restTemplate.exchange(REST_SERVICE_URI + "?grant_type=password&username=hatim&password=hatim", HttpMethod.POST, request, Object.class);
//	        
//	        System.out.println(response.getBody());
//	        
//	        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>)response.getBody();
//	        
//	        System.out.printf( "Access Token: %s, Refresh Token: %s, Token Type: %s, Expires In: %s, Scope: %s" , map.get("access_token"), map.get("refresh_token"), map.get("token_type"), map.get("expires_in"), map.get("scope") );
//	        
//	        
//	        
//	        
//	        HttpHeaders headers2 = new HttpHeaders();
//	    	headers2.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	    	
//	    	
//	    	ResponseEntity<List> response2 = restTemplate.exchange(REST_SERVICE_URI+"/users/user/?access_token="+map.get("access_token"),
//	        		HttpMethod.GET, request, List.class);
//	        List<LinkedHashMap<String, Object>> usersMap = (List<LinkedHashMap<String, Object>>)response2.getBody();
//	        
//	        if(usersMap!=null){
//	            for(LinkedHashMap<String, Object> m : usersMap){
//	                System.out.println("User : id="+m.get("id")+", Name="+m.get("username")+", Age="+m.get("age")+", Salary="+m.get("salary"));;
//	            }
//	        }else{
//	            System.out.println("No user exist----------");
//	        }
//			
//		};
//	}
	
}
