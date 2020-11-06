package com.springboot.ijam.app.constructora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "TokenController", description = "API REST relacionada al Token", tags = "Token")
@RestController
@RequestMapping("/tokens")
public class TokenController {
	
	@Autowired
	private ConsumerTokenServices tokenServices;
	
	@ApiOperation(value = "Revocar token")
	@GetMapping("/anular/{tokenId:.*}")
	public void revokeToken(@PathVariable("tokenId") String token) {
		tokenServices.revokeToken(token);
	}
	
}