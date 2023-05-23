package com.micromongodb.controllers;

import org.springframework.http.ResponseEntity;
import com.micromongodb.dto.VehicleDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VehicleController {

    ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO);

    ResponseEntity<List<VehicleDTO>> getVehicles ();
}
