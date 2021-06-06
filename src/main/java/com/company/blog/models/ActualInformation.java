package com.company.blog.models;


import com.company.blog.controllers.AccountStaffControllers;
import com.company.blog.controllers.AdminControllers;

import javax.persistence.*;

@Entity
public class ActualInformation extends AdminControllers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="text", length=1000)
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
