package com.micromongodb.usecase;

import com.micromongodb.model.Vehicle;

public interface CreateVehicleUserCase {

    Vehicle createdVehicle(Vehicle vehicle);
}
