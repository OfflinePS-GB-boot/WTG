package ru.gb.wtg.models.event;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import ru.gb.wtg.models.location.Location;
import ru.gb.wtg.models.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "events")
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_datetime")
    private LocalDateTime start_datetime;

    @Column(name = "finish_datetime")
    private LocalDateTime finish_datetime;

    @Column(name = "link_event_site")
    private String link_event_site;

    @Column(name = "price")
    private Integer price;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_created_id")
    private User userCreated;

    @ManyToMany
    @JoinTable(
            name = "events_categories",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryForEvent> categoryForEvents;



}
