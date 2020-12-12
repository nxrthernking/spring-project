package com.harbour.webapp.entities;


import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "year_of_issue")
    private String yearOfIssue;

    @Column(name = "manufacturer")
    private String manufacturer;

    @OneToOne
    @JoinColumn(name = "id_owner")
    private Owner owner;

    public Car() {
    }


    public Car(String model, String carNumber, String yearOfIssue, String manufacturer, Owner owner) {
        this.model = model;
        this.carNumber = carNumber;
        this.yearOfIssue = yearOfIssue;
        this.manufacturer = manufacturer;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(String yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
