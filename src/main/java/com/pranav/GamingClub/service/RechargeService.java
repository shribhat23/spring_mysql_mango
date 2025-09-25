package com.pranav.GamingClub.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.GamingClub.Dtos.DoRechargeDto;
import com.pranav.GamingClub.entities.Collection;
import com.pranav.GamingClub.entities.Member;
import com.pranav.GamingClub.entities.Recharge;
import com.pranav.GamingClub.repository.CollectionRepository;
import com.pranav.GamingClub.repository.MemberRepository;
import com.pranav.GamingClub.repository.RechargeRepository;

@Service
public class RechargeService {
	@Autowired private RechargeRepository rechargeRepository;
	@Autowired private MemberRepository memberRepository;
	@Autowired private CollectionRepository collectionRepository;
	
	public Recharge doRecharge(DoRechargeDto rechargeDto) {
		Member member = memberRepository.findById(rechargeDto.getMember_id()).get();
		
		Recharge recharge = new Recharge();
		recharge.setMember(member);
		recharge.setDate_time(LocalDate.now());
		recharge.setAmount(rechargeDto.getAmount());
		rechargeRepository.save(recharge);
		
		member.setBalance(rechargeDto.getAmount());
		memberRepository.save(member);
		
		Optional<Collection> collectOptional =  collectionRepository.findCollectionByDate(LocalDate.now());
		if(collectOptional.isPresent()) {
			Collection collection = collectOptional.get();
			collection.setAmount(collection.getAmount() + rechargeDto.getAmount());
			collectionRepository.save(collection);
		}else {
			Collection collection = new Collection();
			collection.setDate(LocalDate.now());
			collection.setAmount(rechargeDto.getAmount());
			collectionRepository.save(collection);
		}
		return recharge;
	}
}
