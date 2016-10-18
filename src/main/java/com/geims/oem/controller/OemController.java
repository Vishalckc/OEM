package com.geims.oem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.geims.oem.service.OemService;
import com.geims.oem.vo.AssemblyVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "oem")
@Api(value = "OemController")

public class OemController {

	@Autowired
	OemService oemService;

	@ApiOperation(value = "get all assemblies", notes="Return all the assemblies with their required part numbers")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Assembly not found"),
			@ApiResponse(code = 200, message = "Successful response send"),
			@ApiResponse(code = 500, message = "Server error") })
	@RequestMapping(value = "/get/assemblies", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<AssemblyVo> getAllAssemblies() {
		List<AssemblyVo> assemblyVoList = oemService.getAllAssemblies();
		return assemblyVoList;
	}

	@ApiOperation(value = "get a particular Assembly's part numbers", notes = "Return the part Numbers based on a given assembly name")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid assembly name supplied"),
			@ApiResponse(code = 404, message = "Assembly not found"),
			@ApiResponse(code = 200, message = "Successful response send"),
			@ApiResponse(code = 500, message = "Server error") })
	@RequestMapping(value = "/assembly/{assemblyName}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody AssemblyVo getPartNumbersByAssembyName(
			@ApiParam(value = "assemblyName", required = true) @PathVariable("assemblyName") String assemblyName) {
		AssemblyVo assemblyVoObj=oemService.getAssemblyParts(assemblyName);
		return assemblyVoObj;
	}
}