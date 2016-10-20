package com.geims.oem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geims.oem.entity.BookedAssembly;

public interface BookedAssemblyDao extends JpaRepository<BookedAssembly, Long> {

}
