package com.springboot.ijam.app.constructora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ijam.app.constructora.model.ResetToken;
import com.springboot.ijam.app.constructora.service.ILoginService;
import com.springboot.ijam.app.constructora.service.IResetTokenService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "LoginContoller", description = "API REST relacionada al Inicio de Sesion", tags = "Login")
@RestController
@RequestMapping("/login")
public class LoginContoller {
	
	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private IResetTokenService resetTokenService;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@ApiOperation(value = "Restablecer Contrase\u00f1a")
	@GetMapping(value = "/restablecer/verificar/{token}")
	public ResponseEntity<Integer> restorePassword(@PathVariable("token") String token){
		int rpta = 0;
		try {
			if (token != null && !token.isEmpty()) {
				ResetToken rt = resetTokenService.findByToken(token);
				if (rt != null && rt.getId() > 0) {
					if (!rt.estaExpirado()) {
						rpta = 1;
					}
				}
			}
		} catch (Exception e) {
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Restablecer Contrase\u00f1a")
	@PostMapping(value = "/restablecer/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> restorePassword(@PathVariable("token") String token, @RequestBody String clave){
		int rpta = 0;
		try {
			ResetToken rt = resetTokenService.findByToken(token);
			String claveHash = bCryptPasswordEncoder.encode(clave);
			rpta = loginService.changePassword(claveHash, rt.getUser().getUsername());
			resetTokenService.delete(rt);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
	
	
}
