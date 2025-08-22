package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
//	private BuildingServiceImp buildingService = new BuildingServiceImp();
	@GetMapping(value="/api/building/")
    public List<BuildingDTO> getBuilding(@RequestParam(name="name", required = false)String name,
    									@RequestParam(name="districtid", required = false) Long district,
    									@RequestParam(name="typecode", required = false) List<String>typeCode
    		) {
		List<BuildingDTO> result = buildingService.findAll(name,district);
    		return result;

    }
    @DeleteMapping(value="/api/building/{id}/{name}")
    public void deleteBuilding(@PathVariable Integer id,
    		@PathVariable String name,
    		@RequestParam(value="ward",required=false) String ward
    		) {
    		System.out.print("Đã xóa tòa nhà có id: "+id+" ten: "+name);   
    }
   
}
