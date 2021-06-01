package com.company.blog.models;


import javax.persistence.*;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name = "id_booking")
    private int id_booking;
    @Column(name = "payment")
    private int payment;
    @Column(name = "sum")
    private int sum;

    public Payment(long id, int id_booking, int payment, int sum) {
        this.id = id;
        this.id_booking = id_booking;
        this.payment = payment;
        this.sum = sum;
    }

    public Payment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getId_booking() {
        return id_booking;
    }

    public void setId_booking(int id_booking) {
        this.id_booking = id_booking;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}