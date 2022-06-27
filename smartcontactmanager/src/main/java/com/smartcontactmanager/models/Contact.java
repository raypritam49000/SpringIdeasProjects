package com.smartcontactmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String cname;
    private String secondName;
    private String phone;
    private String work;
    @Column(unique = true, nullable = false, length = 100)
    private String email;
    private String image;
    @Column(length = 3000)
    private String description;

    @JsonIgnore
    @ManyToOne
    private User user;

    public Contact() {
        super();
    }

    public Contact(String cname, String secondName, String phone, String work, String email,
                   String description) {
        super();
        this.cname = cname;
        this.secondName = secondName;
        this.phone = phone;
        this.work = work;
        this.email = email;
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        return this.cid == ((Contact)obj).getCid();
    }
}
