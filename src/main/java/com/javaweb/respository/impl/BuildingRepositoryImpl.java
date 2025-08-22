package com.javaweb.respository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.respository.BuildingRepository;
import com.javaweb.respository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "a0903298117";
	
	@Override
	public List<BuildingEntity> findAll(String name, Long districtId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b WHERE 1 = 1 ");
		if(name!=null&&!name.equals("")) {
			sql.append("AND b.name like '%"+name+"%' ");
		}
		if(districtId!=null&&!districtId.equals("")) {
			sql.append("AND b.district = "+districtId+" ");
		}
		List<BuildingEntity> result = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());){
				while(rs.next()) {
					BuildingEntity building = new BuildingEntity();
					building.setName(rs.getString("name"));
					building.setStreet(rs.getString("street"));
					building.setWard(rs.getString("ward"));
					building.setNumberOfBasement(rs.getInt("numberofbasement"));
					result.add(building);
				}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void DeleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
