package code.academy.peopleapi;


import code.academy.base.TestBase;
import code.academy.client.PeopleApiClient;
import code.academy.model.requests.PostNewPersonRequest;
import code.academy.model.responses.GetAllPeopleResponse;
import code.academy.model.responses.PostNewPersonResponse;
import code.academy.payloads.PostNewPersonPayload;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static code.academy.utils.ConversionUtils.jsonStringToObject;
import static org.apache.http.HttpStatus.SC_OK;
import static code.academy.config.HostNameConfig.*;
import static code.academy.config.EndPointConfig.*;
import static code.academy.utils.TestDataUtils.ResponseCode.*;
import static code.academy.utils.TestDataUtils.ResponseMessage.*;


public class RetrieveAllPeopleTest extends TestBase {

    public RetrieveAllPeopleTest() throws Exception {
    }

    GetAllPeopleResponse getAllPeopleResponse;
    PeopleApiClient peopleApiClient = new PeopleApiClient();
    HttpResponse response;






    @Test
    public void GetAllPeopleTest() throws Exception {

        response = peopleApiClient.httpGet(HOSTNAME + GET_PEOPLE_ENDPOINT);
        String body = EntityUtils.toString(response.getEntity());

        //      getAllPeopleResponse = jsonStringToObject(body, GetAllPeopleResponse.class);




        Assert.assertEquals(response.getStatusLine().getStatusCode(), SC_OK);
        Assert.assertEquals(getAllPeopleResponse.getCode(), P200);
        Assert.assertEquals(getAllPeopleResponse.getMessage(), PEOPLE_SUCCESSFULLY_FETCHED);
        Assert.assertNotNull(getAllPeopleResponse.getNumberOfPeople());
        Assert.assertNotNull(getAllPeopleResponse.getPeopleData().size());
    }


    @Test
    public void GetNumberOfAllPeople() throws Exception {
        response = peopleApiClient.httpGet(HOSTNAME + GET_PEOPLE_ENDPOINT);
        String body = EntityUtils.toString(response.getEntity());

        getAllPeopleResponse = jsonStringToObject(body, GetAllPeopleResponse.class);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), SC_OK);
        Assert.assertEquals(getAllPeopleResponse.getCode(), P200);
        Assert.assertEquals(getAllPeopleResponse.getPeopleData().size(),getAllPeopleResponse.getNumberOfPeople());


    }

}