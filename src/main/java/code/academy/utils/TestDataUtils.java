package code.academy.utils;

public class TestDataUtils {

    public static class ResponseMessage{
        public static final String PERSON_SUCCESSFULLY_INSERTED = "Person succesfully inserted";
        public static final String LOCATION_NOT_PROVIDED = "Person's location must be provaded to be updated !";
        public static final String SURNAME_NOT_PROVIDED = "Person's surname cannot be empty";
        public static final String NAME_NOT_PROVIDED = "Person's name cannot be empty";
        public static final String EMPLOYMENT_NOT_PROVIDED ="Person must provide if he is employed or not";
        public static final String LOCATION_SUCCESSFULLY_INSERTED = "Person's location succesfully updated !";
        public static final String BODY_EMPTY = "Request body cannot be empty";
        public static final String PEOPLE_SUCCESSFULLY_FETCHED = "List of people successfully fetched";
        public static final String PERSON_SUCCESSFULLY_FETCHED = "Person succesfully fetched";
    }
    public static class ResponseCode {
        public static final String P200 = "P200";
        public static final String P201 = "P201";
        public static final String P400 = "P400";
        public static final String P404 = "P404";
    }

}
