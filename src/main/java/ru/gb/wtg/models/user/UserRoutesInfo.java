package ru.gb.wtg.models.user;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_routes_info")
@NoArgsConstructor
public class UserRoutesInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_routes_id")
    private UserRoute userRoute;


    @Column(name = "favorites")
    private Boolean favorites;

    @Column(name = "passed")
    private Boolean passed;
}
