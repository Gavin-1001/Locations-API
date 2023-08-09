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
    private String startCity;

    @Column()
    private String startCountry;

    @Column()
    private String endCity;

    @Column()
    private String endCountry;

    @Column()
    private String dateTravelled;

}
