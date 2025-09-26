package com.pranav.GamingClub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.GamingClub.Dtos.DoRechargeDto;
import com.pranav.GamingClub.entities.Recharge;
import com.pranav.GamingClub.service.RechargeService;

@RestController
@RequestMapping
public class RecahrgeController {
	@Autowired RechargeService rechargeService;
	
	@PostMapping("/recharge")
	public Recharge recharge(@RequestBody DoRechargeDto rechargeDto) {
		return rechargeService.doRecharge(rechargeDto);
	}
}
