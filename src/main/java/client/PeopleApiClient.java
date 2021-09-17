package client;

import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.net.ssl.SSLContext;

public class PeopleApiClient {

    public HttpResponse getWelcomeRequest() throws Exception {
        Header contentType = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();

        HttpGet request = new HttpGet("https://people-api1.herokuapp.com");
        request.setHeader(contentType);

        HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();

        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);

        HttpEntity newEntity = new StringEntity(body, ContentType.get(entity));
        response.setEntity(newEntity);

        return response;


    }


    //napravi uste edna metoda sto ke go povikuva
    // nekoj od listata https://people-api1.herokuapp.com/api/person/personID


    //napravi metoda sto ke go povikuva https://people-api1.herokuapp.com/api/people


    public HttpResponse getAllPeople() throws Exception {
        Header contentType = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();

        HttpGet request = new HttpGet("https://people-api1.herokuapp.com/api/people");
        request.setHeader(contentType);

        HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();

        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);

        HttpEntity newEntity = new StringEntity(body, ContentType.get(entity));
        response.setEntity(newEntity);

        return response;
    }


    public HttpResponse DeleteSinglePerson() throws Exception {
        Header contentType = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();

        HttpDelete request = new HttpDelete("https://people-api1.herokuapp.com/api/person/613de0e0dd85560004b265ad");
        request.setHeader(contentType);

        HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();

        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);

        HttpEntity newEntity = new StringEntity(body, ContentType.get(entity));
        response.setEntity(newEntity);

        return response;
    }

    public HttpResponse postNewPerson() throws Exception {
        Header contentType = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();


        HttpPost request = new HttpPost("https://people-api1.herokuapp.com/api/person");
        JSONObject payloadAsObject = new JSONObject();
        payloadAsObject.put("name","Pero");
        payloadAsObject.put("surname","Blazevski");
        payloadAsObject.put("age",56);
        payloadAsObject.put("isEmployed",true);
        payloadAsObject.put("location","Skopje");

        String payloadAsString = payloadAsObject.toString();

        request.setHeader(contentType);
        request.setEntity(new StringEntity(payloadAsObject.toString()));

        HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();

        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);

        HttpEntity newEntity = new StringEntity(body, ContentType.get(entity));
        response.setEntity(newEntity);

        return response;
    }

    //PUT metoda za domasna 
}