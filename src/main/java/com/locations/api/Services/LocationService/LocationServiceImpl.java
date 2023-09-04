package com.locations.api.Services.LocationService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.locations.api.Entity.Locations;
import com.locations.api.Repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//todo => return a a list of the two cities as pairs

@Service
public class LocationServiceImpl implements LocationService {


    @Autowired
    private LocationsRepository locationsRepository;


    @Override
    public Locations createLocation(Locations locations) {
        // System.out.println(locations.getNewEndCity() + " is new end city"); - only returns one city
        return locationsRepository.save(locations);
    }


    @Override
    public Locations updateLocation(String id, Locations locations) {
        return null;
    }

//
//    @Override
//    public List<Locations> getAllEndCities() {
//        //return locationsRepository.findAllByNewEndCity();
//        return null;
//    }

    @Override
    public List<Locations> getAll() {


        return locationsRepository.findAll();
    }

    @Override
    public List<String> getAllLocations(){
        List<String> startCities = new ArrayList<>();
        List<String> endCities = new ArrayList<>();

        return null;
    }

}
