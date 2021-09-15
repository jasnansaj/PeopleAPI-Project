package code.academy.peopleapi;

import client.PeopleApiClient;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;


public class InitialTestFramework{

    PeopleApiClient peopleApiClient = new PeopleApiClient();
    HttpResponse response;



    @Test
    public void initialTest() throws Exception {
        //make a request to people Api
       response = peopleApiClient.getWelcomeRequest();

      String body = EntityUtils.toString(response.getEntity());

        //people Api give back response
        //checking the body in the response

    }
}
