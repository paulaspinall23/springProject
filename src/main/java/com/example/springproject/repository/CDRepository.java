package com.example.springproject.repository;

import com.example.springproject.model.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CDRepository extends JpaRepository<CD, UUID> {
}
