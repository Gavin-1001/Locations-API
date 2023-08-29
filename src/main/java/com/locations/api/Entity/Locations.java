package com.locations.api.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    private String newStartCity;

    @Column()
    private String startCountry;

    @Column()
    private String startCityLat;

    @Column()
    private String startCityLong;

    @Column()
    private String newEndCity;

    @Column()
    private String endCountry;

    @Column()
    private String endCityLat;

    @Column()
    private String endCityLong;

    @Column()
    private String dateTravelled;

}
