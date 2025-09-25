package com.pranav.GamingClub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranav.GamingClub.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
   List<Transaction>  findTransactionByMemberId(int member_id);
}
