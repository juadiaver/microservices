package com.micromongodb.persistence;

import com.micromongodb.model.Vehicle;
import com.micromongodb.usecase.CreateVehicleUserCase;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CreatedVehiclePersistenceAdapter implements CreateVehicleUserCase {

    private final VehicleRepositoryMongo vehicleRepositoryMongo;

    private final ModelMapper modelMapper = new ModelMapper();

    public CreatedVehiclePersistenceAdapter(VehicleRepositoryMongo vehicleRepositoryMongo) {
        this.vehicleRepositoryMongo = vehicleRepositoryMongo;
    }


    @Override
    public Vehicle createdVehicle(Vehicle vehicle) {
        VehicleEntity v = vehicleRepositoryMongo.save(this.modelMapper.map(vehicle,VehicleEntity.class));
        return this.modelMapper.map(v, Vehicle.class);
    }
}
