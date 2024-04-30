package com.example.exala.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "address")
    private String address;
    @Column(name = "date")
    private String date;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "event")
    private List<Image> images = new ArrayList<>();

    public Event() {
    }
    public Event(Long id, String name, String description, String address, String date, List<Image> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.date = date;
        this.images = images;
    }

    public void addImageToProduct(Image image) {
        image.setEvent(this);
        images.add(image);
    }

    public Long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public String getAddress() {
        return this.address;
    }
    public String getDate() {
        return this.date;
    }
    public List<Image> getImages() {
        return this.images;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String toString() {
        return "Event[id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", address=" + this.getAddress() + ", date=" + this.getDate() + ", images=" + this.getImages() + "]";
    }
}
