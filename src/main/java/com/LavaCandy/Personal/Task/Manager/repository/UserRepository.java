package com.LavaCandy.Personal.Task.Manager.repository;

import com.LavaCandy.Personal.Task.Manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // This interface will automatically provide CRUD operations for the User entity.
    // You can add custom query methods if needed, such as finding users by email or name.
    // You can add custom queries here later, like findByEmail()
    // this gives us methods like save(), findAll(), findById(), deleteById() etc.
}
