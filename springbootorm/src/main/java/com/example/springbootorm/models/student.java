package com.example.springbootorm.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Component
@Scope("prototype")
@Entity
public class student {
    @Id
    private int rollNo;
    private String name;
    private int mark;

    
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }
    @Override
    public String toString() {
        return "studemt [rollNo=" + rollNo + ", name=" + name + ", mark=" + mark + "]";
    }

    

}
