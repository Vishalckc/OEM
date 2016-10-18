package com.geims.oem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geims.oem.entity.PartNumber;

public interface PartNumberDao extends JpaRepository<PartNumber, Long> {

}
