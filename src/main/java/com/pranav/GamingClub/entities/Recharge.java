package com.pranav.GamingClub.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="recharges")
public class Recharge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="member_id")
	private Member member;
	private float amount;
	private LocalDate date_time;
	
	
	public Recharge() {}
	public Recharge(Member member, float amount, LocalDate date_time) {
		super();
		this.member = member;
		this.amount = amount;
		this.date_time = date_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public LocalDate getDate_time() {
		return date_time;
	}
	public void setDate_time(LocalDate date_time) {
		this.date_time = date_time;
	}
	
	
	
	
	
}
