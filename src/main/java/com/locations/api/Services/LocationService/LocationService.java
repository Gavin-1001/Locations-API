package com.locations.api.Services.LocationService;

import com.locations.api.Entity.Locations;

import java.util.List;

public interface LocationService {

    Locations createLocation(Locations locations);

    Locations updateLocation(String id, Locations locations);

//    List<Locations> getAllEndCities();

    List<Locations> getAll();

    List<String> getAllLocations();
}
