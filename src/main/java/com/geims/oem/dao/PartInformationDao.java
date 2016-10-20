package com.geims.oem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geims.oem.entity.PartInformation;

public interface PartInformationDao extends JpaRepository<PartInformation, Long>{

}
