package code.academy.peopleapi;

import client.PeopleApiClient;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InitialTestFramework{

    PeopleApiClient peopleApiClient = new PeopleApiClient();
    HttpResponse response;


    @Test
    public void welcomeMessagePeopleApiTest() throws Exception {
        String expectedMessage = "Welcome to People API";
        response = peopleApiClient.httpGet("https://people-api1.herokuapp.com/");

        String body = EntityUtils.toString(response.getEntity());
        JSONObject bodyAsObject = new JSONObject(body);

        String messageAsString = bodyAsObject.get("message").toString();
        Assert.assertEquals(messageAsString,body);





}

        @Test
        public void getSinglePersonTest() throws Exception {
            String expectedMsg = "Person succesfully fetched";
            //nekakov request do people api
            response = peopleApiClient.httpGet("https://people-api1.herokuapp.com/api/person/613de0e0dd85560004b265ad");

            //cel response sme go pretvorile vo String
            String bodySinglePerson = EntityUtils.toString(response.getEntity());
            //cel toj JSON string sme go pretvorile vo objekt
            JSONObject bodyAsObject = new JSONObject(bodySinglePerson);

            //person sum go zemal kako string
            String personDataAsString = bodyAsObject.get("person").toString();
            //persson stringot go pretvaram vo objekt
            JSONObject personData = new JSONObject(personDataAsString);
            //get name
            String name = personData.get("name").toString();
            // bodyAsObject.get("message");//key

            Assert.assertEquals(personDataAsString,expectedMsg);

        }




   @Test
    public void getAllPeopleTest() throws Exception {
        response = peopleApiClient.httpGet("https://people-api1.herokuapp.com/api/people");

        String body = EntityUtils.toString(response.getEntity());
        JSONObject bodyAsObject = new JSONObject(body);
        String messageAsString = bodyAsObject.get("message").toString();
        Assert.assertEquals(messageAsString,body);
   }
   @Test
    public void postPersonTest () throws Exception {
       JSONObject payloadAsObject = new JSONObject();
       payloadAsObject.put("name","Pero");
       payloadAsObject.put("surname","Blazevski");
       payloadAsObject.put("age",56);
       payloadAsObject.put("isEmployed",true);
       payloadAsObject.put("location","Skopje");

       response = peopleApiClient.httpPost("https://people-api1.herokuapp.com/api/person",payloadAsObject);
       String body = EntityUtils.toString(response.getEntity());
       Assert.assertEquals(body,payloadAsObject);
   }

   @Test
    public void postPersonTestWithoutName() throws Exception {
       JSONObject payloadAsObject = new JSONObject();
       payloadAsObject.put("surname","Blazevski");
       payloadAsObject.put("age",56);
       payloadAsObject.put("isEmployed",true);
       payloadAsObject.put("location","Skopje");

       response = peopleApiClient.httpPost("https://people-api1.herokuapp.com/api/person",payloadAsObject);
       String body = EntityUtils.toString(response.getEntity());
       Assert.assertEquals(body,payloadAsObject);
   }

   @Test
    public void UpdatePersonLocationTest() throws Exception {
        JSONObject payloadAsObject = new JSONObject();
        payloadAsObject.put("location","Skopje");

        response = peopleApiClient.httpPut("https://people-api1.herokuapp.com/api/person/613de0e0dd85560004b265ad",payloadAsObject);

        String body = EntityUtils.toString(response.getEntity());
        Assert.assertEquals(body,payloadAsObject);

   }
}