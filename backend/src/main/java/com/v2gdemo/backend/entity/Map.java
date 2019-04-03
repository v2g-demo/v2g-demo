package com.v2gdemo.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "maps")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "map")
    private List<Object> objects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "map")
    private List<Character> characters;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "map")
    private List<RespawnPoint> respawnPoints;

    @NotBlank
    private String name;

    @NotBlank
    private Integer zoom;

    @NotBlank
    private Location center;

    @Data
    @Embeddable
    public static class Location {
        private Double latitude;
        private Double longitude;
    }

    // https://developers.google.com/maps/documentation/javascript/examples/control-bounds-restriction
    private Bounds bounds;

    @Data
    @Embeddable
    public static class Bounds {
        private Double north;
        private Double west;
        private Double south;
        private Double east;
    }
}
