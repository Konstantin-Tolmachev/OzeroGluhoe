package com.company.blog.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActualInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String text;

    public ActualInformation(String text) {
        this.text = text;
    }

    public ActualInformation(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
