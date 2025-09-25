package com.pranav.GamingClub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.GamingClub.entities.Game;
import com.pranav.GamingClub.repository.GameRepository;

@Service
public class GameService {
   @Autowired
	private GameRepository gameRepository;
   
   
   public Game saveGame(Game game) {
	   return gameRepository.save(game);
   }
   
   
   public List<Game> getAllGames(){
	   return gameRepository.findAll();
   }
   
   public boolean deleteGame(int id) {
	   Optional<Game> existingGame = gameRepository.findById(id);
	   if(existingGame.isPresent()) {
		   gameRepository.deleteById(id);
		   return true;
	   }
	   return false;
   }
   
   public Game updateGame(int id,Game game) {
	   Optional<Game> existingGame = gameRepository.findById(id);
	   if(existingGame.isPresent()) {
		   Game oldGame = existingGame.get();
		   oldGame.setName(game.getName());
		   oldGame.setDescription(game.getDescription());
		   oldGame.setAmount(game.getAmount());
		   oldGame.setStatus(game.getStatus());
		   return gameRepository.save(oldGame);   
		   
	   }
	   return null;
   }     
}
