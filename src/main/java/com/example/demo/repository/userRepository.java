package com.example.demo.repository;

import com.example.demo.utils.Enum.EnumStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.user;

import java.util.List;
import java.util.Optional;

public interface userRepository extends JpaRepository<user, Long> {

    List<user> findByStatusAndLocation(EnumStatus status, String Location);

    List<user> findByLocation(String location);

    List<user> findByStatus(EnumStatus status);

    boolean existsByEmail(String email);

    boolean existsByMobileNo(String mobileNo);

    Optional<user> findByIdAndStatus(Long id, EnumStatus status);
}