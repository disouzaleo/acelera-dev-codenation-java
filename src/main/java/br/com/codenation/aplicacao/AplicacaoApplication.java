package br.com.codenation.aplicacao;

import br.com.codenation.aplicacao.controller.AplicacaoController;
import br.com.codenation.aplicacao.controller.DesafioController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

@Configuration
@EnableScheduling
@SpringBootApplication
//@ComponentScan(basePackages = {"br.com.codenation.aplicacao.domain.entity"})
public class AplicacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoApplication.class, args);

//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("application");
//		factory.close();

//		DesafioController controller = new DesafioController();
//
//		controller.createNewEmpresa();
//		controller.createNewUsuario();
//		controller.imprimeMaiorSalario();
//		controller.imprimeMediaSalarial();
//		controller.imprimeValorTotalDaFolha();
//		controller.imprimeEmpresaMenorCusto();
//		controller.imprimeMediaDeIdade();
//		controller.imprimeUsuarioOrdenadoPorIdade();


//		AplicacaoController controller = new AplicacaoController();
//
//		// Empresas
//		controller.createNewEmpresa(1L, "Codenation", "123", 3);
//		controller.createNewEmpresa(2L, "Inter", "1234", 30);
//		controller.createNewEmpresa(3L, "Outra", "12345", 1);
//		// TESTE ERROS
////		controller.createNewEmpresa(4L, "Codenation", "12345", 3);
////		controller.createNewEmpresa(5L, "Id Repetido", "123", 30);
//
//		// Usuarios
//		controller.createNewUsuario(1L, "Daniel", "123" , 28, "dnpimenel", "senha", 3L);
//		controller.createNewUsuario(2L, "Alexsander", "1234" , 30, "usuario", "senha", 2L);
//
//		try {
//			controller.createNewUsuario(3L, "Jarison", "1235" , 30, "usuario2", "senha", 2L);
//		} catch (Exception e){
//			System.out.println(e.getMessage());
//		}
//
//		controller.test();

//		controller.createNewUsuario(4L, "Daniel", "12357" , 30, "usuario", "senha");
//		controller.createNewUsuario(5L, "Outro", "1234" , 30, "usuario", "senha");


		// Teste
//		controller.listUsuario().forEach(usuario -> {
//			System.out.println(usuario.toString());
//		});
//		// Teste
//		controller.listEmpresas().forEach(empresa -> {
//			System.out.println(empresa.toString());
//		});
	}

}
