package junit.gradle;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HelloWorld implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
		

		try {
		   ObjectMapper mapper = new ObjectMapper();
	        JsonNode json = mapper.readTree(event.getBody());
	        String secretKey = System.getenv("SECRET_KEY");

	        String api = json.get("api").asText()+ "&appid="+secretKey;
	        System.out.println("api"+api);

		        
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api)).GET()
					.build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			 // Parse JSON
            //ObjectMapper tresponseMapper = new ObjectMapper();
           // JsonNode resonseJson = tresponseMapper.readTree(response.body());
           // String name = resonseJson.get("name").asText();

			
			return new APIGatewayProxyResponseEvent().withStatusCode(200).withBody(response.body());

		} catch (Exception e) {
			context.getLogger().log("Error: " + e.getMessage());

			return new APIGatewayProxyResponseEvent().withStatusCode(500).withBody("Error fetching data");
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
	}

}
