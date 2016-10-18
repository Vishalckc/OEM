package com.geims.oem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="assembly")
public class Assembly {
	private int id;
	private String assemblyName;
	private List<PartNumber> partNumbers;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "assemblyName")
	public String getAssemblyName() {
		return assemblyName;
	}

	public void setAssemblyName(String assemblyName) {
		this.assemblyName = assemblyName;
	}

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "assemblyPartNumberMappingTable", joinColumns = @JoinColumn(name = "assembly_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "part_number_id", referencedColumnName = "id"))
	public List<PartNumber> getPartNumbers() {
		return partNumbers;
	}

	public void setPartNumbers(List<PartNumber> partNumbers) {
		this.partNumbers = partNumbers;
	}

}
