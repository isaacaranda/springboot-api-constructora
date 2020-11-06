package com.springboot.ijam.app.constructora.service;

import org.springframework.stereotype.Service;

import com.springboot.ijam.app.constructora.model.ResetToken;

@Service
public interface IResetTokenService {
	ResetToken findByToken(String token);
	void save(ResetToken token);
	void delete(ResetToken token);
}
