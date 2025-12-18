package com.app.ecommerceapplication.repository;

import com.app.ecommerceapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//JpaRepository<User, Long> - with User entity(table), and PK id of long type.

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
