package com.geims.oem.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * Assembly Model Vo 
 * @author Vishal Verma
 * @author $LastChangedBy: Vishal Verma
 */

@ApiModel(description = "Rest Api Response Bean")
public class AssemblyVo {
	private String assemblyName;
	private List<PartNumberVo> partNumbers;

	public String getAssemblyName() {
		return assemblyName;
	}

	public void setAssemblyName(String assemblyName) {
		this.assemblyName = assemblyName;
	}

	public List<PartNumberVo> getPartNumbers() {
		return partNumbers;
	}

	public void setPartNumbers(List<PartNumberVo> partNumbers) {
		this.partNumbers = partNumbers;
	}

}
