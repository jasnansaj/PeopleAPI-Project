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
import org.apache.http.client.methods.HttpPut;
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

    public HttpResponse httpGet(String url) throws Exception {
        Header contentType = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();

        HttpGet request = new HttpGet(url);
        request.setHeader(contentType);

        HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();

        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(response.getEntity());

        HttpEntity newEntity = new StringEntity(body, ContentType.get(entity));
        response.setEntity(newEntity);

        return response;
    }


    public HttpResponse HttpDelete(String url) throws Exception {
        Header contentType = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();

        HttpDelete request = new HttpDelete(url);
        request.setHeader(contentType);

        HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();

        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(response.getEntity());

        HttpEntity newEntity = new StringEntity(body, ContentType.get(entity));
        response.setEntity(newEntity);

        return response;
    }

    public HttpResponse httpPost(String url,JSONObject payload) throws Exception {
        Header contentType = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();


        HttpPost request = new HttpPost(url);

        request.setHeader(contentType);
        request.setEntity(new StringEntity(payload.toString()));

        HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();

        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);

        HttpEntity newEntity = new StringEntity(body, ContentType.get(entity));
        response.setEntity(newEntity);

        return response;
    }

    //PUT metoda za domasna

    public HttpResponse httpPut (String url,JSONObject payload) throws Exception {
        Header contentType = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();

        HttpPut  locationUpdate = new HttpPut(url);

        locationUpdate.setHeader(contentType);
        locationUpdate.setEntity(new StringEntity(payload.toString()));

        HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();
        HttpResponse response = httpClient.execute(locationUpdate);

        HttpEntity entityUpdate = response.getEntity();
        String bodyLocationUpdate = EntityUtils.toString(entityUpdate);

        HttpEntity newEntity = new StringEntity(bodyLocationUpdate, ContentType.get(entityUpdate));
        response.setEntity(newEntity);

        return response;

    }


}