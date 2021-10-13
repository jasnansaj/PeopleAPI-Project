package code.academy.peopleapi;



import code.academy.base.TestBase;
import code.academy.client.PeopleApiClient;
import code.academy.model.requests.PostNewPersonRequest;
import code.academy.model.responses.PostNewPersonResponse;
import code.academy.payloads.PostNewPersonPayload;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.*;
import org.json.JSONObject;
import code.academy.config.HostNameConfig.*;
import static code.academy.config.EndPointConfig.*;
import static code.academy.utils.ConversionUtils.jsonStringToObject;
import static code.academy.utils.TestDataUtils.ResponseCode.*;
import static code.academy.utils.TestDataUtils.ResponseMessage.*;

import java.io.IOException;

import static code.academy.config.HostNameConfig.HOSTNAME;
import static code.academy.utils.ConversionUtils.objectToJsonString;



   public class DeletePersonByIDTest  {





     PeopleApiClient peopleApiClient = new PeopleApiClient();
     HttpResponse response;
     PostNewPersonRequest postNewPersonRequest = new PostNewPersonRequest();
     PostNewPersonResponse postNewPersonResponse = new PostNewPersonResponse();
     PostNewPersonPayload postNewPersonPayload = new PostNewPersonPayload();

    String createdPersonId;
    String NonExistingID = "613de0e0dd85560004b265a";



    public DeletePersonByIDTest() throws Exception {
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        HttpResponse postResponse = peopleApiClient.httpPost(HOSTNAME + POST_ENDPOINT,
                objectToJsonString(postNewPersonPayload.createNewPersonPayload()));

        String postResponseBodyAsString = EntityUtils.toString(postResponse.getEntity());
        postNewPersonResponse = jsonStringToObject(postResponseBodyAsString, PostNewPersonResponse.class);

        createdPersonId = postNewPersonResponse.getPersonData().getId();

    }

    @BeforeTest
    public void beforeTest() {

    }

    @Test
    public void deletePersonByIDTest() throws Exception {
//        response = peopleApiClient.httpDelete(HOSTNAME + POST_ENDPOINT + createdPersonId);
//        String body = EntityUtils.toString(response.getEntity());
//       postNewPersonResponse = jsonStringToObject (body, PostNewPersonResponse.class);


        response = peopleApiClient.httpDelete(HOSTNAME + POST_ENDPOINT + createdPersonId);
        String postResponseBodyAsString = EntityUtils.toString(response.getEntity());
        postNewPersonResponse = jsonStringToObject (postResponseBodyAsString, PostNewPersonResponse.class);

        Assert.assertEquals(postNewPersonResponse.getCode(),P200);
        Assert.assertEquals(postNewPersonResponse.getMessage(),"Person with id="+ createdPersonId + " has been succesfully deleted");

    }

    @AfterTest
    public void afterTest() {

    }

    @AfterClass
    public void afterClass() throws Exception {
        peopleApiClient.httpDelete(HOSTNAME + POST_ENDPOINT + createdPersonId);


    }
}