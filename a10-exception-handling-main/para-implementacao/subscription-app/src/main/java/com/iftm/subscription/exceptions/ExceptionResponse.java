package com.iftm.subscription.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
    private Date timestamp;
    private String menssage;
    private String details;

    public ExceptionResponse() {

    }

    public ExceptionResponse(Date timestamp, String menssage, String details) {
        this.timestamp = timestamp;
        this.menssage = menssage;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExceptionResponse that = (ExceptionResponse) o;

        if (!timestamp.equals(that.timestamp)) return false;
        if (!menssage.equals(that.menssage)) return false;
        return details.equals(that.details);
    }

    @Override
    public int hashCode() {
        int result = timestamp.hashCode();
        result = 31 * result + menssage.hashCode();
        result = 31 * result + details.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "timestamp=" + timestamp +
                ", menssage='" + menssage + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
