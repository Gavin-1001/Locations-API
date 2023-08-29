package com.locations.api.Controller;

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


    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(locationsRepository.findAll());
    }

    @PostMapping("create")
    public ResponseEntity<Locations> create(@RequestBody Locations locations){
        return ResponseEntity.ok(locationService.createLocation(locations));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody Locations locations, @PathVariable String id){
        Locations updatedLocations = locationService.updateLocation(id, locations);
        if(updatedLocations == null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(updatedLocations);
        }
    }

}

//Enter location from the form -> type in location of start -> backend gets coords and inserts them into a no edit textbox ->
    //when the object is saved then add use reverse geolocate to get the coords and draw on a map
