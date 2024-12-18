package com.micrud.ventas.ventas.controller;

public class VentasError {

     private String message;
     private long timeStamp;
     private int status;

     public VentasError(String message, long timeStamp, int status){

         this.message=message;
         this.timeStamp=timeStamp;
         this.status=status;
     }

     public VentasError(){

     }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
