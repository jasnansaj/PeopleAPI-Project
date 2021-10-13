package code.academy.peopleapi;

import code.academy.base.TestBase;
import code.academy.client.PeopleApiClient;
import code.academy.model.requests.GetSinglePersonRequest;
import code.academy.model.responses.GetSinglePersonResponse;
import code.academy.payloads.GetSinglePersonPayload;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static code.academy.utils.ConversionUtils.jsonStringToObject;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static code.academy.config.HostNameConfig.*;
import static code.academy.config.EndPointConfig.*;
import static code.academy.utils.TestDataUtils.ResponseCode.*;
import static code.academy.utils.TestDataUtils.ResponseMessage.*;

public class GetSinglePersonTest  {




    PeopleApiClient peopleApiClient = new PeopleApiClient();
    HttpResponse response;
    GetSinglePersonResponse getSinglePersonResponse = new GetSinglePersonResponse();
    GetSinglePersonRequest getSinglePersonRequest = new GetSinglePersonRequest();
    GetSinglePersonPayload getSinglePersonPayload = new GetSinglePersonPayload();
    String PersonID = "613de0e0dd85560004b265ad";
    String PersonNonExistingID = "613de0e0dd85560004b265a";

    public GetSinglePersonTest() throws Exception {
    }

    @Test
    public void getSinglePersonTest() throws Exception{
        response = peopleApiClient.httpGet(HOSTNAME + POST_ENDPOINT + PersonID);


        String body = EntityUtils.toString(response.getEntity());

        getSinglePersonResponse  = jsonStringToObject(body,GetSinglePersonResponse.class);

        Assert.assertEquals(response.getStatusLine().getStatusCode(),SC_OK);
        Assert.assertEquals(getSinglePersonResponse.getCode(),P200);
        Assert.assertEquals(getSinglePersonResponse.getMessage(),PERSON_SUCCESSFULLY_FETCHED);


    }

    @Test
    public void getSinglePersonNonExistingId() throws Exception{
        response = peopleApiClient.httpGet(HOSTNAME + POST_ENDPOINT + PersonNonExistingID);

        String body = EntityUtils.toString(response.getEntity());

        getSinglePersonResponse = jsonStringToObject(body,GetSinglePersonResponse.class);


        Assert.assertEquals(getSinglePersonResponse.getCode(),P404);
        Assert.assertEquals(getSinglePersonResponse.getMessage(), "Person with id 613de0e0dd85560004b265a not found");

    }
}
