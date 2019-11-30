package br.com.codenation.aplicacao.service;

import br.com.codenation.aplicacao.domain.entity.Company;
import br.com.codenation.aplicacao.domain.entity.User;
import br.com.codenation.aplicacao.domain.vo.UserVO;

import java.math.BigDecimal;

public interface UserService {

    User createUser(String name, String document, int age, String login, String password, Long idCompany, BigDecimal salary);

    void deleteUser(User user);

    void deleteUser(Long id);

    UserVO updateNameUserById(Long id, String name);

    void updateCompanyByUserId(Long userId, Long companyId);

}
