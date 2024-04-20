package com.jpa.api.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class testing {
    @Id
    private int id;
    private String name;
    private String data;
    public testing() {
    }

    public testing(int id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return STR."user{id=\{id}, name='\{name}\{'\''}, data='\{data}\{'\''}\{'}'}";
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
