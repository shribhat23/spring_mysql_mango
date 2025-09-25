package com.pranav.GamingClub.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranav.GamingClub.entities.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer>{
    Optional<Collection>  findCollectionByDate(LocalDate date);
}
