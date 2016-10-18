package com.geims.oem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geims.oem.dao.AssemblyDao;
import com.geims.oem.entity.Assembly;
import com.geims.oem.entity.PartNumber;
import com.geims.oem.service.OemService;
import com.geims.oem.vo.AssemblyVo;
import com.geims.oem.vo.PartNumberVo;

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

	// Service to get all assemblies with their associated part numbers
	/*
	 * (non-Javadoc)
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
				partsList.add(partNumberVo);
			}
			assemblyVoObj.setPartNumbers(partsList);
			assemblyVoList.add(assemblyVoObj);
		}
		return assemblyVoList;
	}

	// Service to get a particular assembly for a given assembly name
	/*
	 * (non-Javadoc)
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
			partsList.add(partNumberVoObj);
		}
		assemblyVoObj.setPartNumbers(partsList);
		return assemblyVoObj;

	}

}
