package com.pranav.GamingClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranav.GamingClub.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
