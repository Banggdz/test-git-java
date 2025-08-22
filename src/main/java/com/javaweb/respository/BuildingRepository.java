package com.javaweb.respository;

import java.util.List;

import com.javaweb.respository.entity.BuildingEntity;
public interface BuildingRepository {
	List<BuildingEntity> findAll (String name,Long districtId);
	void DeleteById(Long id);
}
