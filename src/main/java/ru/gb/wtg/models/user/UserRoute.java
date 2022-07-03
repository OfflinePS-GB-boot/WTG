package ru.gb.wtg.models.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.wtg.models.route.Route;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_routes")
@NoArgsConstructor
public class UserRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

}
