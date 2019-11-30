package br.com.codenation.aplicacao.controller;

import br.com.codenation.aplicacao.service.impl.DesafioServiceImpl;

@Deprecated
public class DesafioController {

    DesafioServiceImpl service = new DesafioServiceImpl();

    public void createNewEmpresa(){
        service.importDataEmpresas();
    }

    public void createNewUsuario() {
        service.importDataUsuarios();
    }

    public void imprimeMaiorSalario(){
        service.imprimeMaiorSalario();
    }

    public void imprimeMediaSalarial(){
        service.imprimeMediaSalarial();
    }

    public void imprimeValorTotalDaFolha(){
        service.imprimeValorTotalDaFolha();
    }

    public void imprimeEmpresaMenorCusto(){
        service.imprimeEmpresaMenorCusto();
    }

    public void imprimeMediaDeIdade(){
        service.imprimeMediaDeIdade();
    }

    public void imprimeUsuarioOrdenadoPorIdade(){
        service.imprimeUsuarioOrdenadoPorIdade();
    }

}
