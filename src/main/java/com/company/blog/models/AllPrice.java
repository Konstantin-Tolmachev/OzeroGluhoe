package com.company.blog.models;


import javax.persistence.*;

@Entity
@Table(name = "AllPrice")
public class AllPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private int korpus;
    private int numberRoom;
    private int price;

    public AllPrice(int korpus, int numberRoom, int price) {
        this.korpus = korpus;
        this.numberRoom = numberRoom;
        this.price = price;
    }

    public AllPrice() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getKorpus() {
        return korpus;
    }

    public void setKorpus(int korpus) {
        this.korpus = korpus;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
