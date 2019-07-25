package com.oocl.packagebooking.model;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class Parcel {
    private long id;
    private String recipient;
    private String phoneNumber;
    private String status;
    private Timestamp time;

    public Parcel() {
    }

    public Parcel(long id, String recipient, String phoneNumber, String status, Timestamp time) {
        this.id = id;
        this.recipient = recipient;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
