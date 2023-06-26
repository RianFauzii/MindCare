package astratech.mindcare.vo;


import astratech.mindcare.Model.Pengguna;

public class PenggunaResult {
    private int result;
    private String message;
    private Pengguna data;

    public PenggunaResult() {

    }

    public PenggunaResult(int result, String message, Pengguna data) {
        this.result = result;
        this.message = message;
        this.data = data;
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

    public Pengguna getData() {
        return data;
    }

    public void setData(Pengguna data) {
        this.data = data;
    }
}
