package code.academy.payloads;


import code.academy.model.requests.PostNewPersonRequest;
import org.json.JSONObject;

public class PostNewPersonPayload {


    public PostNewPersonRequest createNewPersonPayload() {
        return PostNewPersonRequest.builder()
                .name("Jasna")
                .surname("Dineva")
                .age(38)
                .isEmployed(true)
                .location("Montreal")
                .build();
    }

    public JSONObject createNewPersonPayloadEmployeAsString(){
        JSONObject personObject = new JSONObject();
        personObject.put("name","Azelia");
        personObject.put("surname","Sayers");
        personObject.put("age",2);
        personObject.put("isEmployed","kako string");
        personObject.put("location","Skopje");

        return personObject;
    }
    public JSONObject PostPersonNameSurnameAsInteger(){
        JSONObject personObject = new JSONObject();
        personObject.put("name",12);
        personObject.put("surname",13);
        personObject.put("age",35);
        personObject.put("isEmployed","kako string");
        personObject.put("location","Toronto");

        return personObject;
    }

    public PostNewPersonRequest createUpdateLocationPayload(){
        return  PostNewPersonRequest.builder()
                .location("Toronto")
                .build();
    }
    public PostNewPersonRequest createUpdateEmptyLocationPayload(){
        return  PostNewPersonRequest.builder()
                .location("")
                .build();
    }

}
