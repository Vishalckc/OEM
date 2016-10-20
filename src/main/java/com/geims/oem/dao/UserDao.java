package com.geims.oem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geims.oem.entity.PartNumber;
import com.geims.oem.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
