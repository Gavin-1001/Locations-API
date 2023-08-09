package com.locations.api.Services.LocationService;

import com.locations.api.Entity.AuthUser;
import com.locations.api.Entity.Locations;
import com.locations.api.Repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.Location;


@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationsRepository locationsRepository;

    @Override
    public Locations createLocation(Locations locations) {
        return locationsRepository.save(locations);
    }


}
