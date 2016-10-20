package com.geims.oem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geims.oem.dao.AssemblyDao;
import com.geims.oem.dao.BookedAssemblyDao;
import com.geims.oem.dao.BookingDao;
import com.geims.oem.dao.PartInformationDao;
import com.geims.oem.dao.UserDao;
import com.geims.oem.dao.WarehouseUsedDao;
import com.geims.oem.entity.Assembly;
import com.geims.oem.entity.BookedAssembly;
import com.geims.oem.entity.Booking;
import com.geims.oem.entity.PartInformation;
import com.geims.oem.entity.PartNumber;
import com.geims.oem.entity.User;
import com.geims.oem.entity.WarehouseUsed;
import com.geims.oem.service.OemService;
import com.geims.oem.vo.AssemblyVo;
import com.geims.oem.vo.BookingTableVo;
import com.geims.oem.vo.PartNumberVo;
import com.geims.oem.vo.ReceivePartVo;
import com.geims.oem.vo.ReceiveVo;
import com.geims.oem.vo.ReceiveWarehouseQuantityVo;
import com.geims.oem.vo.SendVo;

/**
 * Implementation for OEM Service interface
 * 
 * @author Vishal Verma
 * @author $LastChangedBy: Vishal Verma
 * @version $Revision:001 $, $Date: 15/10/2016
 */
@Service
public class OemServiceImpl implements OemService {
	@Autowired
	AssemblyDao assemblyDao;

	@Autowired
	WarehouseUsedDao warehouseUsedDao;

	@Autowired
	PartInformationDao partInformationDao;

	@Autowired
	BookedAssemblyDao bookedAssemblyDao;

	@Autowired
	BookingDao bookingDao;

	@Autowired
	UserDao userDao;

	/*
	 * Service to get all assemblies with their associated part numbers and
	 * recommended quantites (non-Javadoc)
	 * 
	 * @see com.geims.oem.serviceImpl.OemService#getAllAssemblies()
	 */
	public List<AssemblyVo> getAllAssemblies() {
		List<AssemblyVo> assemblyVoList = new ArrayList<>();
		for (Assembly assemblyObj : assemblyDao.findAll()) {
			AssemblyVo assemblyVoObj = new AssemblyVo();
			assemblyVoObj.setAssemblyName(assemblyObj.getAssemblyName());
			List<PartNumberVo> partsList = new ArrayList<>();

			for (PartNumber partNumberObj : assemblyObj.getPartNumbers()) {
				PartNumberVo partNumberVo = new PartNumberVo();
				partNumberVo.setPartNumber(partNumberObj.getPartNumber());
				partNumberVo.setRecommendedQuantity(partNumberObj.getRecommendedQuantity());
				partsList.add(partNumberVo);
			}
			assemblyVoObj.setPartNumbers(partsList);
			assemblyVoList.add(assemblyVoObj);
		}
		return assemblyVoList;
	}

	/*
	 * Service to get a particular assembly with part numbers and recommended
	 * quantities for a given assembly name (non-Javadoc)
	 * 
	 * @see
	 * com.geims.oem.serviceImpl.OemService#getAssemblyParts(java.lang.String)
	 */
	public AssemblyVo getAssemblyParts(String assemblyName) {
		AssemblyVo assemblyVoObj = new AssemblyVo();
		Assembly assemblyObj = assemblyDao.findByAssemblyName(assemblyName);
		assemblyVoObj.setAssemblyName(assemblyObj.getAssemblyName());
		List<PartNumberVo> partsList = new ArrayList<>();

		for (PartNumber partNumberObj : assemblyObj.getPartNumbers()) {
			PartNumberVo partNumberVoObj = new PartNumberVo();
			partNumberVoObj.setPartNumber(partNumberObj.getPartNumber());
			partNumberVoObj.setRecommendedQuantity(partNumberObj.getRecommendedQuantity());
			partsList.add(partNumberVoObj);
		}
		assemblyVoObj.setPartNumbers(partsList);
		return assemblyVoObj;

	}

	// Create a new booking for a given user
	public void createBooking(ReceiveVo receiveVo) {
		try {
			User user = userDao.findByUsername(receiveVo.getUserName());
			Booking booking = new Booking();
			booking.setUser(user);
			booking.setBookingNumber(receiveVo.getBookingNumber());
			BookedAssembly bookedAssembly = new BookedAssembly();
			bookedAssembly.setAssemblyName(receiveVo.getAssemblyName());
			List<PartInformation> partsList = new ArrayList<>();
			for (ReceivePartVo partVo : receiveVo.getPartVo()) {
				PartInformation partInfoObj = new PartInformation();
				partInfoObj.setPartNumber(partVo.getPartNumber());
				partInfoObj.setPrice(partVo.getPrice());

				List<WarehouseUsed> warehouseList = new ArrayList<>();
				for (ReceiveWarehouseQuantityVo whVo : partVo.getWhQtyVo()) {
					WarehouseUsed warehouseObj = new WarehouseUsed();
					warehouseObj.setWarehouseName(whVo.getWarehouseName());
					warehouseObj.setBookedQuantity(whVo.getBookedQuantity());
					warehouseObj.setPartInformation(partInfoObj);
					warehouseObj.setAvailableQuantity(whVo.getAvailableQuantity());
					warehouseList.add(warehouseObj);
					warehouseUsedDao.save(warehouseObj);
				}
				partInfoObj.setWarehouselist(warehouseList);
				partInfoObj.setBookedAssembly(bookedAssembly);
				partsList.add(partInfoObj);
				partInformationDao.save(partInfoObj);
			}
			bookedAssembly.setPartsList(partsList);
			bookedAssembly.setBooking(booking);
			bookedAssemblyDao.save(bookedAssembly);
			booking.setBookedAssembly(bookedAssembly);
			booking.setOrder(null);
			bookingDao.save(booking);
			List<Booking> bookingsList = new ArrayList<>();
			bookingsList.add(booking);
			user.setBookingsList(bookingsList);
			user.setOrdersList(null);
			userDao.save(user);
		} catch (Exception e) {
			System.out.println("Exception in Create Booking Service: ");
		}
	}

	// Send back booking table details by booking number and username
	public SendVo getBookingDetailsByBookingNumberAndUserName(String userName, int bookingNumber){
		SendVo sendVoObj = new SendVo();
		User user = userDao.findByUsername(userName);
		List<Booking> bookingList = user.getBookingsList();
		for (Booking booking : bookingList) {
			if (booking.getBookingNumber() == bookingNumber) {
				sendVoObj.setUsername(user.getUsername());
				sendVoObj.setBookingNumber(booking.getBookingNumber());
				List<BookingTableVo> bookingTableList = new ArrayList<>();

				for (PartInformation part : booking.getBookedAssembly().getPartsList()) {
					BookingTableVo bookingTableObj = new BookingTableVo();
					bookingTableObj.setPartNumber(part.getPartNumber());
					bookingTableObj.setUnitPrice(part.getPrice());
					int availablePartQuantity = getPartQuantity(part.getWarehouselist());
					int bookedQuantity = getBookedQuantity(part.getWarehouselist());
					if (availablePartQuantity - bookedQuantity >= 0) {
						bookingTableObj.setQuantityOnHand(bookedQuantity);
						bookingTableObj.setQuantityNeeded(0);
					} else {
						bookingTableObj.setQuantityOnHand(availablePartQuantity);
						bookingTableObj.setQuantityNeeded(bookedQuantity - availablePartQuantity);
					}
					double totalprice = availablePartQuantity * part.getPrice();
					bookingTableObj.setTotal(totalprice);
					bookingTableList.add(bookingTableObj);
				}
				sendVoObj.setBookingTable(bookingTableList);
			}
		}
		return sendVoObj;
		
	}

	// get total quantity booked by a user for a given part
	private int getBookedQuantity(List<WarehouseUsed> warehouselist) {
		int quantity = 0;
		for (WarehouseUsed warehouse : warehouselist) {
			quantity += warehouse.getBookedQuantity();
		}
		return quantity;
	}

	// Get total availably qty for a given part
	private int getPartQuantity(List<WarehouseUsed> warehouselist) {
		int quantity = 0;
		for (WarehouseUsed warehouse : warehouselist) {
			quantity += warehouse.getAvailableQuantity();
		}
		return quantity;
	}

}
