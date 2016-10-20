package com.geims.oem.vo;

import java.util.List;

public class ReceiveVo {

	private String userName;
	private int bookingNumber;
	private String assemblyName;
	private List<ReceivePartVo> partVo;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(int bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public String getAssemblyName() {
		return assemblyName;
	}

	public void setAssemblyName(String assemblyName) {
		this.assemblyName = assemblyName;
	}

	public List<ReceivePartVo> getPartVo() {
		return partVo;
	}

	public void setPartVo(List<ReceivePartVo> partVo) {
		this.partVo = partVo;
	}

}
