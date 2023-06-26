package astratech.mindcare.vo;

public class Result {
    private int result;
    private String message;

    public Result(){

    }

    public Result(int result, String message){
        this.result = result;
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
