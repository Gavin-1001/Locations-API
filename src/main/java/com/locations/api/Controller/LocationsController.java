package com.locations.api.Controller;

import com.locations.api.Entity.AuthUser;
import com.locations.api.Entity.Locations;
import com.locations.api.Repository.LocationsRepository;
import com.locations.api.Services.LocationService.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations/")
public class LocationsController {

    @Autowired
    private LocationsRepository locationsRepository;

    @Autowired
    private LocationService locationService;

//    @GetMapping("{authUserId}/getAll")
//    public ResponseEntity<Locations> getAll(@PathVariable String authUserId){
//        return ResponseEntity.ok(locationsRepository.findAllById(authUserId));
//    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(@PathVariable Long id){
        return ResponseEntity.ok(locationsRepository.findAllById(id));
    }

    @PostMapping("create")
    public ResponseEntity<Locations> create(@RequestBody Locations locations){
        return ResponseEntity.ok(locationService.createLocation(locations));
    }
}
