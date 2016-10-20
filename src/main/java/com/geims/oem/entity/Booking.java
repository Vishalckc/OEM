package com.geims.oem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="booking")
public class Booking {
	private int id;
	private int bookingNumber;
	private User user;
	private Order order;
	//This entity is required as the user can repeat the same assembly or this assembly can be added to available assembly lists
	private BookedAssembly bookedAssembly;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name="bookingNumber")
	public int getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(int bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	@OneToOne(mappedBy="booking")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@JoinColumn(name = "assembly_id", referencedColumnName = "id")
	@OneToOne(cascade=CascadeType.ALL)
	public BookedAssembly getBookedAssembly() {
		return bookedAssembly;
	}

	public void setBookedAssembly(BookedAssembly bookedAssembly) {
		this.bookedAssembly = bookedAssembly;
	}

}
