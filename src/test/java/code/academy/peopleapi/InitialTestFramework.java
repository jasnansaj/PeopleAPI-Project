package code.academy.peopleapi;

import client.PeopleApiClient;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;


public class InitialTestFramework{

    PeopleApiClient peopleApiClient = new PeopleApiClient();
    HttpResponse response;
  //  HttpResponse getPeople;
   // HttpResponse getSinglePerson;

    @Test
    public void initialTest() throws Exception {
        //make a request to people Api
       response = peopleApiClient.postNewPerson();
     //  getPeople = peopleApiClient.getAllPeople();
     //  getSinglePerson = peopleApiClient.getSinglePerson();

      String body = EntityUtils.toString(response.getEntity());
    //  String bodyAllPeople = EntityUtils.toString(getPeople.getEntity());
    //  String bodySinglePerson = EntityUtils.toString(getSinglePerson.getEntity());

        //people Api give back response
        //checking the body in the response

    }
}
