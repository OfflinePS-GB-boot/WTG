package ru.gb.wtg.models.user;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.wtg.models.event.Event;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_events")
@NoArgsConstructor
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users")
    private User user;

    @ManyToOne
    @JoinColumn(name = "events")
    private Event event;

    @OneToOne(mappedBy = "userEvent")
    UserEventsInfo userEventsInfo;


}
