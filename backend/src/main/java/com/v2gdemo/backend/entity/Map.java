package com.v2gdemo.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotNull
    private Integer zoom;

    @NotNull
    private Location center;

    @Data
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Location {
        private Double latitude;
        private Double longitude;
    }

    // https://developers.google.com/maps/documentation/javascript/examples/control-bounds-restriction
    private Bounds bounds;

    @Data
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Bounds {
        private Double north;
        private Double west;
        private Double south;
        private Double east;
    }
}
