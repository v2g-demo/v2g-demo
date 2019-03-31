package com.v2gdemo.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "objects")
public class MapObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String placeId;

    private String formattedAddress;
    private String reference; //wallet reference

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Type type;
    public enum Type {
        Vehicle,
        House,
        Charger,
        Office
    }


    private Location location;

    @Data
    @Embeddable
    public static class Location {
        private Long latitude;
        private Long longitude;
        private Integer angle;
    }

//    @NotBlank
//    private Long latitude;
//
//    @NotBlank
//    private Long longitude;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
