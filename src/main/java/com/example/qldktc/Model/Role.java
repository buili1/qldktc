package com.example.qldktc.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;


@Entity
@Table(name="role")
public class Role {
    @Id
    @Column(name = "id", length = 45)
    private int id;

    @Column(name = "role", length = 255)
    private String role;

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

