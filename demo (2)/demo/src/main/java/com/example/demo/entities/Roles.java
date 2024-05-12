package com.example.demo.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Members members;

    public Roles() {
        // Default constructor required by JPA
    }

    public Roles(String userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Members getMember() {
        return members;
    }

    public void setMember(Members members) {
        this.members = members;
    }
}
