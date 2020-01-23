package com.techshard.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.techshard.graphql.dao.entity.Vehicle;
import com.techshard.graphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleQuery implements GraphQLQueryResolver {

    @Autowired
    private VehicleService vehicleService;

    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }

    public Optional<Vehicle> getVehicle( int id) {
        return this.vehicleService.getVehicle(id);
    }
    
    public List<Vehicle> getVehiclebybrandname( String brandName) {
        return this.vehicleService.getVehicleByBrandName(brandName);
    }
    
    
    public List<Vehicle> getVehiclebybrandnameandmodelCode( String brandName, String modelCode) {
        return this.vehicleService.getVehicleByBrandNameAndModelCode(brandName,modelCode);
    }
}
