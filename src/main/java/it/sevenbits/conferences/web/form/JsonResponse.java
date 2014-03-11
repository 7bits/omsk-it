package it.sevenbits.conferences.web.form;

/**
 * POJO class for server json response representation.
 * Status - SUCCESS or FAIL.
 * Result - an Object with some result information, for example a Map with form fields errors and a message.
 */
public class JsonResponse {

    /**
     * Status of a success response
     */
    public static final String STATUS_SUCCESS = "SUCCESS";
    /**
     * Status of a not success response
     */
    public static final String STATUS_FAIL = "FAIL";

    private String status;
    private Object result;

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(final Object result) {
        this.result = result;
    }
}
