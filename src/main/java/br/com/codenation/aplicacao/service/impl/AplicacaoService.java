package br.com.codenation.aplicacao.service.impl;

import br.com.codenation.aplicacao.domain.entity.Company;
import br.com.codenation.aplicacao.domain.entity.User;
import br.com.codenation.aplicacao.exception.EmpresaException;
import br.com.codenation.aplicacao.exception.UsuarioException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Deprecated
public class AplicacaoService implements br.com.codenation.aplicacao.service.AplicacaoService {

    Logger LOG = LoggerFactory.getLogger(br.com.codenation.aplicacao.service.impl.AplicacaoService.class);
    private List<User> listUser = new ArrayList<>();
    private List<Company> listCompany = new ArrayList<>();

    @Override
    public void createNewUsuarioJava8(Long id, String nome, String documento, int idade, String login, String senha, Long idEmpresa, BigDecimal salario) {
        Company company = findEmpresaById(idEmpresa);

        validaUsuario(id, nome, documento, idade, login, senha);
        User newUser = toOjectUsuario(id, nome, documento, idade, login, senha, company, salario);
        validaUsuarioExiste(newUser);

        listUser.add(newUser);
        addNewUserInEmpresa(newUser, company);
    }

    @Override
    public void createNewEmpresaJava8(Long id, String nome, String documento, int vagas, String site) {
//        Company newCompany = toOjectEmpresa(id, nome, documento, vagas, site);
//        validaEmpresaExiste(newCompany);
//        listCompany.add(newCompany);
    }

    private void validaEmpresaExiste(Company newCompany) {
        if (listCompany.stream().filter(company -> company.equals(newCompany)).findFirst().isPresent()) {
            throw new EmpresaException("#### ERROR - A EMPRESA " + newCompany.getName() + " JA EXISTE");
        }
    }

    private void validaUsuarioExiste(User newUser) {
        if (listUser.stream().filter(usuario -> usuario.equals(newUser)).findFirst().isPresent()) {
            throw new UsuarioException("#### ERROR - USUARIO " + newUser.getName() + " JA EXISTE");
        }
    }

    private void validaUsuario(Long id, String nome, String documento, int idade, String login, String senha) {
        if (!isUsuarioValido(id, nome, documento, idade, login, senha)) {
            throw new UsuarioException("#### ERROR - TODOS OS CAMPOS SAO OBRIGATORIOS");
        }
    }

    private boolean isUsuarioValido(Long id, String nome, String documento, int idade, String login, String senha) {
        if (nome == null || nome.isEmpty() || documento == null || documento.isEmpty() || login == null || login.isEmpty() || senha == null || senha.isEmpty() || idade == 0) {
            return false;
        }
        return true;
    }

    private User toOjectUsuario(Long id, String nome, String documento, int idade, String login, String senha, Company company, BigDecimal salario) {
        User user = new User();
        user.setId(id);
        user.setName(nome);
        user.setAge(idade);
        user.setUsername(login);
        user.setPassword(senha);
        user.setDocument(documento);
        user.setCompany(company);
        user.setSalary(salario);
        return user;
    }

//    private Company toOjectEmpresa(Long id, String nome, String documento, int vagas, String site) {
//        Company company = new Company();
//        company.setId(id);
//        company.setName(nome);
//        company.setDocument(documento);
//        company.setVacancies(vagas);
//        company.setSite(site);
//        return company;
//    }

    private Company findEmpresaById(Long id) {
        Company findCompany = listCompany.stream().filter(company -> company.getId().equals(id)).findFirst().orElse(null);
        if (findCompany == null) {
            LOG.error("#### EMPRESA NAO ENCONTRADA, NAO E POSSIVEL INSERIR USUARIO");
            throw new UsuarioException("#### EMPRESA NAO ENCONTRADA, NAO E POSSIVEL INSERIR USUARIO");
        }
        return findCompany;
    }

    private void addNewUserInEmpresa(User user, Company company) {
        for (int i = 0; i < listCompany.size(); i++) {
            if (listCompany.get(i).equals(company)) {
                List<User> list = listCompany.get(i).getListUser();
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(user);
                listCompany.get(i).setListUser(list);
            }
        }
    }

    public void test() {
        listCompany.forEach(company -> {
            System.out.println(company.toString());
            if (null != company.getListUser()) {
                company.getListUser().forEach(usuario -> {
                    System.out.println("  -  " + usuario.toString());
                });
            } else {
                System.out.println("  -  NENHUM USUARIO NESSA EMPRESA");
            }
        });
    }

    /**
     * @param idEmpresa
     * @param nome
     * @param documento
     * @param idade
     * @return "Usuario: Daniel - Empresa: Codenation"
     */
    @Override
    public List<User> find(Long idEmpresa, String nome, String documento, int idade) {
        // TODO: Implentar
        return null;
    }

    @Override
    public void imprimeMaiorSalario() {
        listCompany.forEach(company -> {
            LOG.info("O maior salario da {} é {}", company.getName(), getMaiorSalarioPorEmpresa(company.getId()));
        });
        LOG.info("O maior salario de todos é {} ", getMaiorSalario());
    }

    @Override
    public void imprimeMediaSalarial() {
        listCompany.forEach(company -> {
            BigDecimal totalSalario = getTotalFolha(company);
            LOG.info("A média salarial da empresa {} é de {}", company.getName(), totalSalario.divide(new BigDecimal(company.getListUser().size()), BigDecimal.ROUND_HALF_UP));
        });
    }

    @Override
    public void imprimeValorTotalDaFolha() {
        listCompany.forEach(company -> {
            BigDecimal totalSalario = getTotalFolha(company);
            LOG.info("A folha total da empresa {} é de {}", company.getName(), totalSalario);
        });
    }

    @Override
    public void imprimeEmpresaMenorCusto() {
        AtomicReference<BigDecimal> menorCusto = new AtomicReference<>(new BigDecimal(0));

        listCompany.forEach(company -> {
            BigDecimal totalFolha = getTotalFolha(company);
            if (menorCusto.get().equals(BigDecimal.ZERO)) {
                menorCusto.set(totalFolha);
                return;
            }
            if (totalFolha.compareTo(menorCusto.get()) == -1) {
                System.out.println(totalFolha);
                menorCusto.set(totalFolha);
            }

        });
        LOG.info("O Menor custo é {}", menorCusto.get());
    }

    @Override
    public void imprimeMediaDeIdade() {
        listCompany.forEach(company -> {
            LOG.info("A média de idade da empresa {} é de {}", company.getName(), getTotalIdade(company) / company.getListUser().size());
        });
    }

    @Override
    public void imprimeUsuarioOrdenadoPorIdade() {
        listCompany.forEach(company -> {
            List<User> users = company.getListUser();
            Collections.sort(company.getListUser(),
                    Comparator.comparing(User::getAge).thenComparing(User::getId));

            System.out.println(company.getName());
            users.forEach(usuario -> {
                System.out.println(usuario.toString());
            });
        });

    }

    private BigDecimal getMaiorSalario() {
        AtomicReference<BigDecimal> maiorSalario = new AtomicReference<>(new BigDecimal(0));
        listUser.forEach(usuario -> {
            if (maiorSalario.get().compareTo(usuario.getSalary()) == -1) {
                maiorSalario.set(usuario.getSalary());
            }
        });
        return maiorSalario.get();
    }

    private BigDecimal getMenorSalario() {
        AtomicReference<BigDecimal> maiorSalario = new AtomicReference<>(getMaiorSalario());
        listUser.forEach(usuario -> {
            if (maiorSalario.get().compareTo(usuario.getSalary()) == 1) {
                maiorSalario.set(usuario.getSalary());
            }
        });
        return maiorSalario.get();
    }

    private BigDecimal getMaiorSalarioPorEmpresa(Long idEmpresa) {
        AtomicReference<BigDecimal> maiorSalario = new AtomicReference<>(new BigDecimal(0));
        Company company = findEmpresaById(idEmpresa);
        company.getListUser().forEach(usuario -> {
            if (maiorSalario.get().compareTo(usuario.getSalary()) == -1) {
                maiorSalario.set(usuario.getSalary());
            }
        });
        return maiorSalario.get();
    }

    private BigDecimal getMenorSalarioPorEmpresa(Long idEmpresa) {
        AtomicReference<BigDecimal> maiorSalario = new AtomicReference<>(new BigDecimal(0));
        Company company = findEmpresaById(idEmpresa);
        company.getListUser().forEach(usuario -> {
            if (maiorSalario.get().compareTo(usuario.getSalary()) == 1) {
                maiorSalario.set(usuario.getSalary());
            }
        });
        return maiorSalario.get();
    }

    private BigDecimal getTotalFolha(Company company) {
        return company.getListUser().stream()
                .map(User::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Integer getTotalIdade(Company company) {

        return company.getListUser().stream()
                .map(User::getAge)
                .reduce(Integer::sum).get();

//        AtomicReference<Integer> totalIdade = new AtomicReference<>(0);
//        empresa.getListaUsuario().forEach(usuario -> {
//            totalIdade.getAndUpdate(v -> v + usuario.getIdade());
//        });
//        return totalIdade.get();
    }


    // Lixo daqui pra baixo, só manti pra ter de exemplos
    @Deprecated
    public void createNewUsuario(Long id, String nome, String documento, int idade, String login, String senha, Long idEmpresa, BigDecimal salario) {
        Company company = findEmpresaById(idEmpresa);
        if (company != null) {

            if (!isUsuarioValido(id, nome, documento, idade, login, senha)) {
                System.out.println("#### ERROR - TODOS OS CAMPOS SAO OBRIGATORIOS");
                return;
            }
            //Inserir usuario na lista de usarios da empresa

            User newUser = toOjectUsuario(id, nome, documento, idade, login, senha, company, salario);
            List<User> list = new ArrayList<>();
            if (listUser.size() > 0) {
                listUser.forEach(usuario -> {
                    if (usuario.equals(newUser)) {
                        System.out.println("#### ERROR - USUARIO " + newUser.getName() + " JA EXISTE");
                    } else {
                        System.out.println("#### INCLUSAO DE USUARIO " + newUser.getName() + " FEITA COM SUCESSO");
                        list.add(usuario);
                    }
                });
            } else {
                System.out.println("#### INCLUSAO DE USUARIO " + newUser.getName() + " FEITA COM SUCESSO");
                list.add(newUser);
            }
            listUser.addAll(list);
        } else {
            System.out.println("#### EMPRESA NAO ENCONTRADA, NAO E POSSIVEL INSERIR USUARIO");
        }

    }

    @Deprecated
    public void createNewEmpresa(Long id, String nome, String documento, int vagas, String site) {
//        Company newCompany = toOjectEmpresa(id, nome, documento, vagas, site);
//        List<Company> list = new ArrayList<>();
//        if (listCompany.size() > 0) {
//            listCompany.forEach(company -> {
//                if (company.equals(newCompany)) {
//                    LOG.info("#### ERROR - A EMPRESA " + newCompany.getName() + " JA EXISTE");
//                } else {
//                    LOG.info("#### INCLUSAO DE EMPRESA " + newCompany.getName() + " FEITA COM SUCESSO");
//                    list.add(newCompany);
//                }
//            });
//        } else {
//            LOG.info("#### INCLUSAO DE EMPRESA " + newCompany.getName() + " FEITA COM SUCESSO");
//            list.add(newCompany);
//        }
//        listCompany.addAll(list);
    }
}
