package ru.gb.wtg.models.route;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import ru.gb.wtg.models.location.Location;
import ru.gb.wtg.models.user.User;
import ru.gb.wtg.models.user.UserRoute;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "routes")
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="duration")
    private LocalDateTime duration;

    @Column(name="distance")
    private Double distance;

    @ManyToOne
    @JoinColumn(name = "routes_categories_id")
    private RouteCategory routeCategory;

    @ManyToOne
    @JoinColumn(name = "user_created_id")
    private User userCreated;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "routes_locations",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<Location> locations;

    @OneToMany(mappedBy = "route")
    List<UserRoute> userRoutes;


}
