package com.locations.api.Repository;

import com.locations.api.Entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationsRepository extends JpaRepository<Locations, Long> {

    List<Locations> findAll();

    List<Locations> findAllByNewEndCity(String newEndCity);




}
