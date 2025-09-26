package com.pranav.GamingClub.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.GamingClub.Dtos.MembershipDto;
import com.pranav.GamingClub.entities.Collection;
import com.pranav.GamingClub.entities.Member;
import com.pranav.GamingClub.entities.Recharge;
import com.pranav.GamingClub.entities.Transaction;
import com.pranav.GamingClub.repository.CollectionRepository;
import com.pranav.GamingClub.repository.MemberRepository;
import com.pranav.GamingClub.repository.RechargeRepository;
import com.pranav.GamingClub.repository.TransactionRepository;

@Service
public class MemberService {
    @Autowired MemberRepository memberRepository;
    @Autowired RechargeRepository rechargeRepository;
    @Autowired CollectionRepository collectionRepository;
    @Autowired TransactionRepository transactionRepository;
    
    public Member createMembership(MembershipDto memberDto) {
    	
    	Member member = new Member();
    	member.setName(memberDto.getName());
    	member.setPhone(memberDto.getPhone());
    	member.setBalance(memberDto.getFees());
    	memberRepository.save(member);
    	
    	Recharge recharge = new Recharge();
    	recharge.setMember(member);
    	recharge.setAmount(memberDto.getFees());
    	recharge.setDate_time(LocalDate.now());
    	rechargeRepository.save(recharge);
    	
    	Optional<Collection> collectionOpt = collectionRepository.findCollectionByDate(LocalDate.now());
    	if(collectionOpt.isPresent()) {
    		Collection collection = collectionOpt.get();
    		collection.setAmount(collection.getAmount() + memberDto.getFees());
    		collectionRepository.save(collection);
    	}else {
    		Collection collection = new Collection();
    		collection.setDate(LocalDate.now());
    		collection.setAmount(memberDto.getFees());
    		collectionRepository.save(collection);
    		}	
    	return member;
    }
    
    public List<Member> getAllMember(){
    	return memberRepository.findAll();
    }
    
    public Map<String, Object> searchMember(String phone){
    	Member member = memberRepository.findMemberByPhone(phone);
    	List<Recharge> recharge = rechargeRepository.findRechargeByMemberId(member.getId());
    	List<Transaction> transaction = transactionRepository.findTransactionByMemberId(member.getId());
    	
    	Map<String, Object> response= new HashMap<String, Object>();
    	response.put("member", member);
    	response.put("recharge_history", recharge);
    	response.put("transaction_history", transaction);
    	
    	return response;
    }
}
