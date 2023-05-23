package com.micromongodb.persistence;

import com.micromongodb.model.Vehicle;
import com.micromongodb.usecase.GetVehicleUserCase;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetVehiclesPersistenceAdapter implements GetVehicleUserCase {

    private final VehicleRepositoryMongo vehicleRepositoryMongo;

    private final ModelMapper modelMapper = new ModelMapper();

    public GetVehiclesPersistenceAdapter(VehicleRepositoryMongo vehicleRepositoryMongo) {
        this.vehicleRepositoryMongo = vehicleRepositoryMongo;
    }
    @Override
    public List<Vehicle> getVehicle() {
        return vehicleRepositoryMongo.findAll().stream().map(vehicle -> this.modelMapper.map(vehicle, Vehicle.class)).toList();
    }
}
