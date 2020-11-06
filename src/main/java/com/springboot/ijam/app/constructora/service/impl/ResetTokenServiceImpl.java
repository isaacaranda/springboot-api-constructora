package com.springboot.ijam.app.constructora.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.ijam.app.constructora.model.ResetToken;
import com.springboot.ijam.app.constructora.repo.IResetTokenRepo;
import com.springboot.ijam.app.constructora.service.IResetTokenService;

@Service
public class ResetTokenServiceImpl implements IResetTokenService {
	
	private IResetTokenRepo tokenRepo;

	@Override
	public ResetToken findByToken(String token) {
		return tokenRepo.findByToken(token);
	}

	@Override
	public void save(ResetToken token) {
		tokenRepo.save(token);
	}

	@Override
	public void delete(ResetToken token) {
		tokenRepo.delete(token);
	}

}
