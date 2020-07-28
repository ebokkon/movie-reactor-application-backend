package com.codecool.moviereactorapplication.repository;

import com.codecool.moviereactorapplication.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    Optional<Visitor> findByUsername(String username);
    Visitor getByUsername(String username);
}
