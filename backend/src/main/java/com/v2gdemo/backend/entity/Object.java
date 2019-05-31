package com.v2gdemo.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "objects")
public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="map_id")
    @JsonBackReference("obz")
    private Map map;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "wallet_id", referencedColumnName = "id")
  private Wallet wallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id")
    @JsonBackReference("objects")
    private Character owner;


    @NotBlank
    private String name;

    //@NotBlank commented because of testing
    private String placeId; // google maps

    private String formattedAddress;
    private String reference; //wallet payment system reference

    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;
    public enum Type {
        VEHICLE,
        HOUSE,
        CHARGER,
        OFFICE
    }


    private Location location;
    private Integer rotationAngle;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class Location {
        private Double latitude;
        private Double longitude;
    }

}
