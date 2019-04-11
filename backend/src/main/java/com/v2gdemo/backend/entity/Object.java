package com.v2gdemo.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id")
    @JsonBackReference("objects")
    private Character owner;

//    @OneToOne(mappedBy = "object")
//    @JsonManagedReference("tasks")
//    private Wallet wallet;

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
