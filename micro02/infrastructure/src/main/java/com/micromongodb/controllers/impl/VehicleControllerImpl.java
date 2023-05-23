package com.micromongodb.controllers.impl;

import com.micromongodb.controllers.VehicleController;
import com.micromongodb.dto.VehicleDTO;
import com.micromongodb.model.Vehicle;
import com.micromongodb.persistence.CreatedVehiclePersistenceAdapter;
import com.micromongodb.persistence.GetVehiclesPersistenceAdapter;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleControllerImpl implements VehicleController {

    private final CreatedVehiclePersistenceAdapter createdVehiclePersistenceAdapter;

    private final GetVehiclesPersistenceAdapter getVehiclesPersistenceAdapter;

    private final ModelMapper modelMapper = new ModelMapper();

    public VehicleControllerImpl(CreatedVehiclePersistenceAdapter createdVehiclePersistenceAdapter, GetVehiclesPersistenceAdapter getVehiclesPersistenceAdapter) {
        this.createdVehiclePersistenceAdapter = createdVehiclePersistenceAdapter;
        this.getVehiclesPersistenceAdapter = getVehiclesPersistenceAdapter;
    }

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle createVehicle = createdVehiclePersistenceAdapter.createdVehicle(this.modelMapper.map(vehicleDTO, Vehicle.class));
        return new ResponseEntity<>(this.modelMapper.map(createVehicle, VehicleDTO.class), HttpStatus.CREATED);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<VehicleDTO>> getVehicles() {
        return new ResponseEntity<>(getVehiclesPersistenceAdapter.getVehicle().stream().map(vehicle -> this.modelMapper.map(vehicle,VehicleDTO.class)).toList(), HttpStatus.OK);
    }
}
