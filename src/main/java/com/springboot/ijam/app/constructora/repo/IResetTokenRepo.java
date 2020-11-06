package com.springboot.ijam.app.constructora.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ijam.app.constructora.model.ResetToken;

public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer>{
	ResetToken findByToken(String token);
}
