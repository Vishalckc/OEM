package com.geims.oem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="partInformation")
public class PartInformation {

	private int id;
	private int partNumber;
	private double price;
	private BookedAssembly bookedAssembly;
	private List<WarehouseUsed> warehouselist;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="partNumber")
	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	@Column(name="price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "bookedAssembly_id")
	public BookedAssembly getBookedAssembly() {
		return bookedAssembly;
	}

	public void setBookedAssembly(BookedAssembly bookedAssembly) {
		this.bookedAssembly = bookedAssembly;
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = WarehouseUsed.class, cascade = CascadeType.ALL, mappedBy = "partInformation")
	@Fetch(FetchMode.JOIN)
	public List<WarehouseUsed> getWarehouselist() {
		return warehouselist;
	}

	public void setWarehouselist(List<WarehouseUsed> warehouselist) {
		this.warehouselist = warehouselist;
	}

}
