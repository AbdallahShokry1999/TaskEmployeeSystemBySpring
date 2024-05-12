package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Members {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "pw")
    private String password;

    @Column(name = "active")
    private short active;

    public Members() {
        // Default constructor required by JPA
    }

    public Members(String userId, String password, short active) {
        this.userId = userId;
        this.password = password;
        this.active = active;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short isActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }
}