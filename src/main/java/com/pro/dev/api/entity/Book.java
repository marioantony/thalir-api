package com.pro.dev.api.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "requestedBag")
	private Integer requestedBag;

	@Column(name = "acceptedBag")
	private Integer acceptedBag;

	@Column(name = "totalAmount")
	private Double totalAmount;

	@ManyToOne
	@JoinColumn(name = "schedule_id", nullable = false, updatable = false)
	private Schedule schedule;

	@ManyToOne
	@JoinColumn(name = "farmer_id", nullable = false, updatable = false)
	private Farmer farmer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRequestedBag() {
		return requestedBag;
	}

	public void setRequestedBag(Integer requestedBag) {
		this.requestedBag = requestedBag;
	}

	public Integer getAcceptedBag() {
		return acceptedBag;
	}

	public void setAcceptedBag(Integer acceptedBag) {
		this.acceptedBag = acceptedBag;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
}
