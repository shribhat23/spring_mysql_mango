package com.pranav.GamingClub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.GamingClub.Dtos.PlayGameDto;
import com.pranav.GamingClub.entities.Transaction;
import com.pranav.GamingClub.service.TransactionService;

import jakarta.transaction.TransactionScoped;

@RestController
@RequestMapping("/transaction")
public class TransactionContoller {
	@Autowired TransactionService transactionService;
	
	@PostMapping("/play")
	public Transaction playGame(@RequestBody PlayGameDto gameDto) {
		return transactionService.playGame(gameDto);
	}
}
