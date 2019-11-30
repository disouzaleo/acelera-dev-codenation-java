package br.com.codenation.aplicacao.service;

import br.com.codenation.aplicacao.domain.entity.User;

import java.math.BigDecimal;
import java.util.List;

@Deprecated
public interface AplicacaoService {

    void createNewUsuarioJava8(Long id, String nome, String documento, int idade, String login, String senha, Long idEmpresa, BigDecimal salario);

    void createNewEmpresaJava8(Long id, String nome, String documento, int vagas, String site);

    List<User> find(Long idEmpresa, String nome, String documento, int idade);

    void imprimeMaiorSalario();

    void imprimeMediaSalarial();

    void imprimeValorTotalDaFolha();

//    void imprimeEmpresaMaiorCusto();

    void imprimeEmpresaMenorCusto();

    void imprimeMediaDeIdade();

    void imprimeUsuarioOrdenadoPorIdade();


//    Imprima o maior salário de cada empresa e o maior salário geral.
//    Imprima a média salarial de cada empresa.
//    Imprima o valor total da folha de cada empresa.
//    Imprima qual a empresa que tem o menor custo.
//    Imprima a média de idade.
//    Ordene e imprima todos os usuários por idade em cada empresa.
}
