package com.pro.dev.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "maxAllowedBag")
    private Integer maxAllowedBag;

    @Column(name = "departureTime")
    private String departureTime;

    @Column(name = "departureLocation")
    private String departureLocation;

    @Column(name = "destinationLocation")
    private String destinationLocation;

    @Column(name = "amountPerBag")
    private Double amountPerBag;

    @ManyToOne
    @JoinColumn(name = "vehicleOwner_id", nullable = false, updatable = false)
    private VehicleOwner vehicleOwner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMaxAllowedBag() {
        return maxAllowedBag;
    }

    public void setMaxAllowedBag(Integer maxAllowedBag) {
        this.maxAllowedBag = maxAllowedBag;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public Double getAmountPerBag() {
        return amountPerBag;
    }

    public void setAmountPerBag(Double amountPerBag) {
        this.amountPerBag = amountPerBag;
    }

    public VehicleOwner getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(VehicleOwner vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }
}
