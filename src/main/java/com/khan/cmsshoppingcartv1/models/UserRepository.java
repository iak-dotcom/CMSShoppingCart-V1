package com.khan.cmsshoppingcartv1.models;
import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.cmsshoppingcartv1.models.data.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}
