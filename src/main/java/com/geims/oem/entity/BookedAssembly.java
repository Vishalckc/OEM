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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="bookedAssembly")
public class BookedAssembly {
	private int id;
	private String assemblyName;
	private Booking booking;
	private List<PartInformation> partsList;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="assemblyName")
	public String getAssemblyName() {
		return assemblyName;
	}

	public void setAssemblyName(String assemblyName) {
		this.assemblyName = assemblyName;
	}
	
	@OneToOne(mappedBy="bookedAssembly")
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = PartInformation.class, cascade = CascadeType.ALL, mappedBy = "bookedAssembly")
	@Fetch(FetchMode.JOIN)
	public List<PartInformation> getPartsList() {
		return partsList;
	}

	public void setPartsList(List<PartInformation> partsList) {
		this.partsList = partsList;
	}

}
