package com.geims.oem.vo;

public class ReceiveWarehouseQuantityVo {
	private String warehouseName;
	private int availableQuantity;
	private int bookedQuantity;

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public int getBookedQuantity() {
		return bookedQuantity;
	}

	public void setBookedQuantity(int bookedQuantity) {
		this.bookedQuantity = bookedQuantity;
	}

}
