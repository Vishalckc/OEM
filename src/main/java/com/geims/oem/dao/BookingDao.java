package com.geims.oem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geims.oem.entity.Booking;

public interface BookingDao extends JpaRepository<Booking, Long> {

}
