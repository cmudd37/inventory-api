package com.cam.inventory_api.repository;

import com.cam.inventory_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
