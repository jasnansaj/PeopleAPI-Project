package code.academy.payloads;


import code.academy.model.requests.GetSinglePersonRequest;

public class GetSinglePersonPayload {

    public GetSinglePersonRequest existingPersonPayload(){
        return GetSinglePersonRequest.builder()
                .name("Jasna")
                .surname("Dineva")
                .age(38)
                .isEmployed(true)
                .location("Montreal")
                .build();
    }


}