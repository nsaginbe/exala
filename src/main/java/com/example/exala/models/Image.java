package com.example.exala.models;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "originalFileName")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "contentType")
    private String contentType;
    @Column(name = "bytes", columnDefinition = "LONGBLOB")
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Event event;

    public Image() {
    }
    public Image(Long id, String name, String originalFileName, Long size, String contentType, byte[] bytes, Event event) {
        this.id = id;
        this.name = name;
        this.originalFileName = originalFileName;
        this.size = size;
        this.contentType = contentType;
        this.bytes = bytes;
        this.event = event;
    }

    public Long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getOriginalFileName() {
        return this.originalFileName;
    }
    public Long getSize() {
        return this.size;
    }
    public String getContentType() {
        return this.contentType;
    }
    public byte[] getBytes() {
        return this.bytes;
    }
    public Event getEvent() {
        return this.event;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }
    public void setSize(Long size) {
        this.size = size;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
    public void setEvent(Event event) {
        this.event = event;
    }

    public String toString() {
        return "Image[id=" + this.getId() + ", name=" + this.getName() + ", originalFileName=" + this.getOriginalFileName() + ", size=" + this.getSize() + ", contentType=" + this.getContentType() + ", bytes=" + java.util.Arrays.toString(this.getBytes()) + ", event=" + this.getEvent() + "]";
    }
}
