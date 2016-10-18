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
@Table(name = "partNumber")
public class PartNumber {
	private int id;
	private int partNumber;
	private List<Assembly> assemblies;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "partNumber")
	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "assemblyPartNumberMappingTable", joinColumns = @JoinColumn(name = "part_number_id)", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "assembly_id", referencedColumnName = "id"))
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="partNumbers")
	public List<Assembly> getAssemblies() {
		return assemblies;
	}

	public void setAssemblies(List<Assembly> assemblies) {
		this.assemblies = assemblies;
	}

}
