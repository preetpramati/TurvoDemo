package com.techshard.graphql.dao.repository;

import com.techshard.graphql.dao.entity.Vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends Neo4jRepository<Vehicle, Integer> {

	List<Vehicle> findByBrandName(String brandName);

	List<Vehicle> findByBrandNameAndModelCode(String brandName, String modelCode);
	
	
}
