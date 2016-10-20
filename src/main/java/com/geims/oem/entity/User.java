package com.geims.oem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table(name="user")
public class User {
	private int id;
	private String username;
	private long contactNumber;
	private List<Order> ordersList;
	private List<Booking> bookingsList;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="contactNumber")
	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Booking.class, cascade = CascadeType.ALL, mappedBy = "user")
	@Fetch(value = FetchMode.SUBSELECT)
	public List<Booking> getBookingsList() {
		return bookingsList;
	}

	
	public void setBookingsList(List<Booking> bookingsList) {
		this.bookingsList = bookingsList;
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Order.class, cascade = CascadeType.ALL, mappedBy = "user")
	@Fetch(value = FetchMode.SUBSELECT)
	public List<Order> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}
	

}
