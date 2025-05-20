package junit.gradle;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.common.collect.ImmutableList;

public class HelloWorld implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>  {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        String format = "YYYY-MM-DD";

        if (event.getQueryStringParameters() != null && event.getQueryStringParameters().containsKey("format")) {
            format = event.getQueryStringParameters().get("format");
        }

        String message = "Hello222222222222, " + format + "!";

        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody(message);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println(listOf("a", "b"));
	}
	

	public static ImmutableList<String> listOf(String... items) {
	     return ImmutableList.copyOf(items);
	 }

}
