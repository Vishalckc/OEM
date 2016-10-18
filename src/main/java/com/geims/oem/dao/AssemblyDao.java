package com.geims.oem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geims.oem.entity.Assembly;

public interface AssemblyDao extends JpaRepository<Assembly, Long> {
	
	public List<Assembly> findAll();
	public Assembly findById(int id);
	public Assembly findByAssemblyName(String assemblyName);
	
}
