package com.micromongodb.usecase;


import com.micromongodb.model.Vehicle;

import java.util.List;

public interface GetVehicleUserCase {

    List<Vehicle> getVehicle ();
}
