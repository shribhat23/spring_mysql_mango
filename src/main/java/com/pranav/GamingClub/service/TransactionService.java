package com.pranav.GamingClub.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.GamingClub.Dtos.PlayGameDto;
import com.pranav.GamingClub.entities.Game;
import com.pranav.GamingClub.entities.Member;
import com.pranav.GamingClub.entities.Transaction;
import com.pranav.GamingClub.repository.GameRepository;
import com.pranav.GamingClub.repository.MemberRepository;
import com.pranav.GamingClub.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired TransactionRepository transactionRepository;
	@Autowired MemberRepository memberRepo;
	@Autowired GameRepository gameRepo;
	
	public Transaction playGame(PlayGameDto gameDto) {
		Member member= memberRepo.findById(gameDto.getMember_id()).get();
		Game game= gameRepo.findById(gameDto.getGame_id()).get();
		
		Transaction transaction =new Transaction();
		transaction.setMember(member);
		transaction.setGame(game);
		transaction.setAmount(game.getAmount());
		transaction.setDate(LocalDateTime.now());
		transactionRepository.save(transaction);
		
		member.setBalance(member.getBalance() - game.getAmount());
		memberRepo.save(member);
		
		return transaction;
	}
}
