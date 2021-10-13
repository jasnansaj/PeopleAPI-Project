package code.academy.payloads;


import code.academy.model.requests.PostNewPersonRequest;

public class PutNewLocationPayload {

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


    public PostNewPersonRequest createNewPersonPayload() {
        return PostNewPersonRequest.builder()
                .name("Jasna")
                .surname("Dineva")
                .age(38)
                .isEmployed(true)
                .location("Montreal")
                .build();
    }

}

