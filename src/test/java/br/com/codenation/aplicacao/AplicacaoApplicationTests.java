package br.com.codenation.aplicacao;

import br.com.codenation.aplicacao.annotation.MetodoAnnotation;
import br.com.codenation.aplicacao.service.impl.DesafioServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;

@SpringBootTest
class AplicacaoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testReflection(){
		DesafioServiceImpl desafioService = new DesafioServiceImpl();
		for (Method methods: desafioService.getClass().getDeclaredMethods()){
			if(methods.getAnnotation(MetodoAnnotation.class) != null){
				assertEquals("importDataUsuarios", methods.getName());
//				System.out.println(methods.getName());
			}
		}
	}
}
