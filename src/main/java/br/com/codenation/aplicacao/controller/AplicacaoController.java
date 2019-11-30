package br.com.codenation.aplicacao.controller;

import br.com.codenation.aplicacao.domain.entity.User;
import br.com.codenation.aplicacao.service.impl.AplicacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;


@Deprecated
public class AplicacaoController {

    Logger LOG = LoggerFactory.getLogger(AplicacaoController.class);

    AplicacaoService service = new AplicacaoService();

    public void createNewUsuario(Long id, String nome, String documento, int idade, String login, String senha, Long idEmpresa, BigDecimal salario) {
        service.createNewUsuarioJava8(id, nome, documento, idade, login, senha, idEmpresa, salario);
    }

    public void createNewEmpresa(Long id, String nome, String documento, int vagas, String site){
        service.createNewEmpresaJava8(id,nome,documento,vagas, site);
    }

    public List<User> findUserByEmpresa(Long idEmpresa, String nome, String documento, int idade){
        return service.find(idEmpresa,nome,documento,idade);
    }

    public void test(){
        service.test();
    }

}
