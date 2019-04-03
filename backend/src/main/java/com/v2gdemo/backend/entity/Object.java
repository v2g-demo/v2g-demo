package com.v2gdemo.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "objects")
public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="map_id")
    private Map map;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private Character owner;

    @OneToOne(mappedBy = "object")
    private Wallet wallet;

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

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
