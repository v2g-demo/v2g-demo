package com.v2gdemo.backend.entity;

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
 @OneToMany( fetch = FetchType.EAGER,mappedBy = "car")
  private Set<Task> carsInTask;

    @ManyToOne
    @JoinColumn(name="map_id")
    private Map map;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="owner_id")
    private Character owner;

   @OneToMany(fetch = FetchType.EAGER,mappedBy = "to")
  private Set<Task> tasks;


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
