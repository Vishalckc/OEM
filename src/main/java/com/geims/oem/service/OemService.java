package com.geims.oem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geims.oem.vo.AssemblyVo;
import com.geims.oem.vo.ReceiveVo;
import com.geims.oem.vo.SendVo;

/**
 * Service interface for OEM
 * @author Vishal Verma
 * @author $LastChangedBy: Vishal Verma
 * @version $Revision:001 $, $Date: 15/10/2016
 */
@Service
public interface OemService {

	// Service to get all assemblies with their associated part numbers
	List<AssemblyVo> getAllAssemblies();

	// Service to get a particular assembly for a given assembly name
	AssemblyVo getAssemblyParts(String assemblyName);

	//Saves the booking data
	public void createBooking(ReceiveVo receiveVo);

	//Send the booking data
	SendVo getBookingDetailsByBookingNumberAndUserName(String userName, int bookingNumber);

}