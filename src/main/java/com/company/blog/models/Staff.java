package com.company.blog.models;



import javax.persistence.*;

@Entity
//@Table(name = "Staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

  //  @Table(indexes = {@Index(columnList="personnelNumber", unique = true)})

 // @GeneratedValue(strategy = ??? ) Какое поле выше то и ядвляется уникальным ключем
    private Long id;
    private String fname, lname, pname, position;


    public Staff( String fname, String lname, String pname, String position) {

        this.fname = fname;
        this.lname = lname;
        this.pname = pname;
        this.position = position;
    }


    public Staff() {

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

}

