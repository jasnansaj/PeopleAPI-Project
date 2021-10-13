
package code.academy.peopleapi;


import code.academy.base.TestBase;
import code.academy.client.PeopleApiClient;
import code.academy.model.requests.PostNewPersonRequest;
import code.academy.model.responses.PostNewPersonResponse;
import code.academy.model.responses.PutNewLocationResponse;
import code.academy.payloads.PostNewPersonPayload;
import code.academy.payloads.PutNewLocationPayload;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static code.academy.utils.ConversionUtils.jsonStringToObject;
import static code.academy.utils.ConversionUtils.objectToJsonString;
import static org.apache.http.HttpStatus.*;
import static code.academy.config.HostNameConfig.*;
import static code.academy.config.EndPointConfig.*;
import static code.academy.utils.TestDataUtils.ResponseCode.*;
import static code.academy.utils.TestDataUtils.ResponseMessage.*;

public class UpdatePersonLocationTest {



    PeopleApiClient peopleApiClient = new PeopleApiClient();
    HttpResponse response;

    PostNewPersonResponse postNewPersonResponse = new PostNewPersonResponse();
    PostNewPersonPayload postNewPersonPayload = new PostNewPersonPayload();

    PutNewLocationPayload putNewLocationPayload;

    PostNewPersonRequest putNewLocationRequest = putNewLocationPayload.createNewPersonPayload();
    PutNewLocationResponse putNewLocationResponse;

    String createPersonID;
    String invalidId = "kljjalglajhdb0898696";



    public UpdatePersonLocationTest() throws Exception {
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        PostNewPersonRequest creteNewPersonRequest = putNewLocationPayload.createNewPersonPayload();
        String requestBody = objectToJsonString(creteNewPersonRequest);
        HttpResponse createPersonResponse = peopleApiClient.httpPost(HOSTNAME + POST_ENDPOINT,requestBody);
        String responseBody = EntityUtils.toString(createPersonResponse.getEntity());
        PostNewPersonResponse postNewPersonResponse = jsonStringToObject(responseBody,PostNewPersonResponse.class);
        createPersonID=postNewPersonResponse.getPersonData().getId();
    }

    @Test
    public void UpdatePersonLocationTest() throws Exception {
        String requestBody = objectToJsonString(putNewLocationRequest);
        response = peopleApiClient.httpPut(HOSTNAME + POST_ENDPOINT + createPersonID, requestBody);

        String responseBody = EntityUtils.toString(response.getEntity());
        putNewLocationResponse = jsonStringToObject(responseBody, PutNewLocationResponse.class);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), SC_OK);
        Assert.assertEquals(putNewLocationResponse.getCode(), P200);
        Assert.assertEquals(putNewLocationResponse.getMessage(), LOCATION_SUCCESSFULLY_INSERTED);
        Assert.assertEquals(putNewLocationResponse.getPerson().getLocation(), putNewLocationRequest.getLocation());

    }

    @Test
    public void updateNonExistingPersonsLocation() throws Exception {
        String requestBody = objectToJsonString(putNewLocationRequest);

        response = peopleApiClient.httpPut(HOSTNAME + POST_ENDPOINT + invalidId, requestBody);

        String responseBody = EntityUtils.toString(response.getEntity());
        putNewLocationResponse = jsonStringToObject(responseBody, PutNewLocationResponse.class);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), SC_NOT_FOUND);
//        Assert.assertEquals(putUpdateLocationResponse.getCode(),P404);
        Assert.assertEquals(putNewLocationResponse.getMessage(), "Person with id="+ invalidId
                +" not found");
    }


    @Test
    public void updatePersonsLocationEmptyRequest() throws Exception {
        PostNewPersonRequest updateEmptyLocationRequest = putNewLocationPayload.createUpdateEmptyLocationPayload();
        updateEmptyLocationRequest.setLocation(null);
        String requestBody = objectToJsonString(updateEmptyLocationRequest);

        response = peopleApiClient.httpPut(HOSTNAME + POST_ENDPOINT + invalidId, requestBody);

        String responseBody = EntityUtils.toString(response.getEntity());
        putNewLocationResponse = jsonStringToObject(responseBody, PutNewLocationResponse.class);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), SC_BAD_REQUEST);
        Assert.assertEquals(putNewLocationResponse.getCode(), P400);
        Assert.assertEquals(putNewLocationResponse.getMessage(), BODY_EMPTY);
    }

    @AfterClass
    public void afterClass() throws Exception {
        HttpResponse deleteResponse = peopleApiClient.httpDelete(HOSTNAME + POST_ENDPOINT + createPersonID);
        Assert.assertEquals(deleteResponse.getStatusLine().getStatusCode(), SC_OK);
    }
}