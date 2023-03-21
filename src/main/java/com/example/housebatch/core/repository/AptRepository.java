package com.example.housebatch.core.repository;

import com.example.housebatch.core.entity.Apt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AptRepository extends JpaRepository<Apt, Long> {
    Optional<Apt> findAptByAptNameAndJibun(String aptName, String jibun);
}
