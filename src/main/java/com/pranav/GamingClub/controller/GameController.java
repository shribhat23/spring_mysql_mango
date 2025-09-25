package com.pranav.GamingClub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.GamingClub.entities.Game;
import com.pranav.GamingClub.service.GameService;


@RestController
@RequestMapping("/game")
public class GameController {
   
	@Autowired
	private GameService gameService;
	
	@PostMapping("/save")
	public Game save(@RequestBody Game game) {
		return gameService.saveGame(game);
	}
	@GetMapping("/all")
	public List<Game> findAll(){
		return gameService.getAllGames();
	}
	
	@PutMapping("/{id}")
	public Game update(@PathVariable int id,@RequestBody Game game) {
		return gameService.updateGame(id, game);
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		return gameService.deleteGame(id);
	}
}
