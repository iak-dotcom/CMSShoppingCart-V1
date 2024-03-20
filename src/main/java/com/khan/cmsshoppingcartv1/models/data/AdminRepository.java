package com.khan.cmsshoppingcartv1.models.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByUsername(String username);
}
