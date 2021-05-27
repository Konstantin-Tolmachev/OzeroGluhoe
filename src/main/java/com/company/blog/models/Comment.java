package com.company.blog.models;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Comment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private long id;

//    @Lob
    @Column(name="text", length=1000)
    //@Size(max=2, message = "Не меньше 5 знаков")
    private String text;

    private String name, email, commentDate;

    public Comment(String name, String email, String text, String commentDate) {
//        this.id = id;
        this.commentDate = commentDate;
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
}
