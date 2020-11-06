package com.springboot.ijam.app.constructora;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.ijam.app.constructora.model.Usuario;
import com.springboot.ijam.app.constructora.repo.IUsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApiConstructoraApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Test
	public void crearUsuario() {
		Usuario us = new Usuario();
		us.setIdUsuario(1);
		us.setUsername("ingenieria@gmail.com");
		us.setPassword(bCryptPasswordEncoder.encode("123"));
		us.setEnabled(true);
		
		Usuario retorno = usuarioRepo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
