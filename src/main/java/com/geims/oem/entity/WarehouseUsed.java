package com.geims.oem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "warehouse_used")
public class WarehouseUsed {
	private int id;
	private String warehouseName;
	private int availableQuantity;
	private int bookedQuantity;
	private PartInformation partInformation;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "warehouseName")
	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	@Column(name = "availableQuantity")
	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	@Column(name = "bookedQuantity")
	public int getBookedQuantity() {
		return bookedQuantity;
	}

	public void setBookedQuantity(int bookedQuantity) {
		this.bookedQuantity = bookedQuantity;
	}

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "part_information_id")
	public PartInformation getPartInformation() {
		return partInformation;
	}

	public void setPartInformation(PartInformation partInformation) {
		this.partInformation = partInformation;
	}

}
