package com.geims.oem.vo;

import java.util.List;

public class SendVo {
	private String username;
	private int bookingNumber;
	private List<BookingTableVo> bookingTable;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(int bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public List<BookingTableVo> getBookingTable() {
		return bookingTable;
	}

	public void setBookingTable(List<BookingTableVo> bookingTable) {
		this.bookingTable = bookingTable;
	}

}
