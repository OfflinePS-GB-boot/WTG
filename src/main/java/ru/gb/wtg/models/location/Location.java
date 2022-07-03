package ru.gb.wtg.models.location;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import ru.gb.wtg.models.route.Route;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "locations")
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "fullDescription")
    private String fullDescription;

    @Column(name = "address")
    private String address;

    @Column(name = "work_time_start")
    private LocalDateTime workTimeStart;

    @Column(name = "work_time_end")
    private LocalDateTime workTimeEnd;

    @Column(name = "link_image")
    private String linkImage;

    @Column(name = "link_site")
    private String linkSite;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "locations_categories",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryForLocation> categoryForLocations;

    @ManyToMany
    @JoinTable(
            name = "routes_locations",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id")
    )
    private List<Route> routes;



}
