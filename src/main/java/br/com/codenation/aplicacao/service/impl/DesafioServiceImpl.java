package br.com.codenation.aplicacao.service.impl;

import br.com.codenation.aplicacao.service.DesafioServiceInterface;
import br.com.codenation.aplicacao.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

@Deprecated
public class DesafioServiceImpl implements DesafioServiceInterface {

    AplicacaoService aplicacaoService = new AplicacaoService();
    private static final String PATH_EMPRESA = "/users/daniel/Desktop/arquivos/empresa.txt";
    private static final String PATH_USUARIO = "/users/daniel/Desktop/arquivos/usuarios.txt";

    //Teste
    public static void main(String[] args) {
        DesafioServiceImpl service = new DesafioServiceImpl();

        service.aplicacaoService.imprimeMaiorSalario();
        service.aplicacaoService.imprimeMediaSalarial();
        service.aplicacaoService.imprimeValorTotalDaFolha();
        service.aplicacaoService.imprimeEmpresaMenorCusto();
        service.aplicacaoService.imprimeMediaDeIdade();
        service.aplicacaoService.imprimeUsuarioOrdenadoPorIdade();
    }

    @Override
    @MetodoAnnotation(text = "Metodo que processa aquivo")
    public void importDataUsuarios() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH_USUARIO));
            Long id = 0L;
            while (br.ready()) {
                String linha = br.readLine();
                if (linha.equals("nome;documento;idade;login;senha;empresa;salario")) {
                    continue;
                }

                String array[] = linha.split(";");

                aplicacaoService.createNewUsuarioJava8(++id, array[0], array[1], Integer.parseInt(array[2]), array[3], criptograSenha(array[4]), Long.parseLong(array[5]), new BigDecimal(array[6]));

            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public void importDataEmpresas() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH_EMPRESA));
            Long id = 0L;
            while (br.ready()) {
                String linha = br.readLine();
                if (linha.equals("nome;documento;vagas;site")) {
                    continue;
                }
                String array[] = linha.split(";");

                aplicacaoService.createNewEmpresaJava8(++id, array[0], array[1], Integer.parseInt(array[2]), array[3]);

            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public void imprimeMaiorSalario() {
        aplicacaoService.imprimeMaiorSalario();
    }

    @Override
    public void imprimeMediaSalarial() {
        aplicacaoService.imprimeMediaSalarial();
    }

    @Override
    public void imprimeValorTotalDaFolha() {
        aplicacaoService.imprimeValorTotalDaFolha();
    }

    @Override
    public void imprimeEmpresaMenorCusto() {
        aplicacaoService.imprimeEmpresaMenorCusto();
    }

    @Override
    public void imprimeMediaDeIdade() {
        aplicacaoService.imprimeMediaDeIdade();
    }

    @Override
    public void imprimeUsuarioOrdenadoPorIdade() {
        aplicacaoService.imprimeUsuarioOrdenadoPorIdade();
    }

    @MetodoAnnotation(text = "Criptografia")
    private String criptograSenha(String senha) {
        return senha.replace("u", "#0P")
                .replace("s", "[%0")
                .replace("e", "lD7")
                .replace("r", "çA=");
    }

//    private void validaUsuarioExiste(Usuario usuarioNovo) {
//        if (usuarioList.stream().filter(usuario -> usuario.equals(usuarioNovo)).findFirst().isPresent()) {
//            throw new UsuarioException("#### ERROR - USUARIO " + usuarioNovo.getNome() + " JA EXISTE");
//        }
//    }
//
//    private void validaUsuario(Long id, String nome, String documento, int idade, String login, String senha) {
//        if (!isUsuarioValido(id, nome, documento, idade, login, senha)) {
//            throw new UsuarioException("#### ERROR - TODOS OS CAMPOS SAO OBRIGATORIOS");
//        }
//    }
//
//    private boolean isUsuarioValido(Long id, String nome, String documento, int idade, String login, String senha) {
//        if (nome == null || nome.isEmpty() || documento == null || documento.isEmpty() || login == null || login.isEmpty() || senha == null || senha.isEmpty() || idade == 0) {
//            return false;
//        }
//        return true;
//    }
//
//    private Empresa findEmpresaById(Long id) {
//        Empresa empresaFind = empresaList.stream().filter(empresa -> empresa.getId().equals(id)).findFirst().orElse(null);
//        if (empresaFind == null) {
//            throw new UsuarioException("#### EMPRESA NAO ENCONTRADA, NAO E POSSIVEL INSERIR USUARIO");
//        }
//        return empresaFind;
//    }
//
//    private void addNewUserInEmpresa(Usuario usuario, Empresa empresa) {
//        for (int i = 0; i < empresaList.size(); i++) {
//            if (empresaList.get(i).equals(empresa)) {
//                List<Usuario> list = empresaList.get(i).getListaUsuario();
//                if (list == null) {
//                    list = new ArrayList<>();
//                }
//                list.add(usuario);
//                empresaList.get(i).setListaUsuario(list);
//            }
//        }
//    }
//
//    private void validaEmpresaExiste(Empresa empresaNova) {
//        if (empresaList.stream().filter(empresa -> empresa.equals(empresaNova)).findFirst().isPresent()) {
//            throw new EmpresaException("#### ERROR - A EMPRESA " + empresaNova.getNome() + " JA EXISTE");
//        }
//    }
//
//    private Empresa toOjectEmpresa(Long id, String nome, String documento, int vagas, String site) {
//        Empresa empresa = new Empresa();
//        empresa.setId(id);
//        empresa.setNome(nome);
//        empresa.setDocumento(documento);
//        empresa.setVagas(vagas);
//        empresa.setSite(site);
//        return empresa;
//    }
//
//    private Usuario toOjectUsuario(Long id, String nome, String documento, int idade, String login, String senha, Empresa empresa) {
//        Usuario usuario = new Usuario();
//        usuario.setId(id);
//        usuario.setNome(nome);
//        usuario.setIdade(idade);
//        usuario.setLogin(login);
//        usuario.setSenha(senha);
//        usuario.setDocumento(documento);
//        usuario.setEmpresa(empresa);
//        return usuario;
//    }
//
//    public void test() {
//        empresaList.forEach(empresa -> {
//            System.out.println(empresa.toString());
//            if (null != empresa.getListaUsuario()) {
//                empresa.getListaUsuario().forEach(usuario -> {
//                    System.out.println("  -  " + usuario.toString());
//                });
//            } else {
//                System.out.println("  -  NENHUM USUARIO NESSA EMPRESA");
//            }
//        });
//    }

}
