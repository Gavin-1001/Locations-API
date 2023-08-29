package com.locations.api.Services.LocationService;

import com.locations.api.Entity.AuthUser;
import com.locations.api.Entity.Locations;

public interface LocationService {

    Locations createLocation(Locations locations);

    Locations updateLocation(String id, Locations locations);
}
