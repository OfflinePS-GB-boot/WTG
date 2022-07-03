package ru.gb.wtg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.wtg.models.user.User;

public interface UserRepository extends JpaRepository<User, Long> {






}
