package com.geims.oem.vo;

import java.util.List;

public class ReceivePartVo {
	private int partNumber;
	private double price;
	private List<ReceiveWarehouseQuantityVo> whQtyVo;

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<ReceiveWarehouseQuantityVo> getWhQtyVo() {
		return whQtyVo;
	}

	public void setWhQtyVo(List<ReceiveWarehouseQuantityVo> whQtyVo) {
		this.whQtyVo = whQtyVo;
	}

}
