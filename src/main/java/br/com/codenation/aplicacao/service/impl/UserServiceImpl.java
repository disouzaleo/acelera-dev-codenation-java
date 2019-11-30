package br.com.codenation.aplicacao.service.impl;

import br.com.codenation.aplicacao.domain.dao.CompanyDao;
import br.com.codenation.aplicacao.domain.dao.UserDao;
import br.com.codenation.aplicacao.domain.entity.Company;
import br.com.codenation.aplicacao.domain.entity.User;
import br.com.codenation.aplicacao.domain.vo.AddressVO;
import br.com.codenation.aplicacao.domain.vo.CompanyVO;
import br.com.codenation.aplicacao.domain.vo.UserVO;
import br.com.codenation.aplicacao.service.UserService;
import com.sun.media.sound.ModelMappedInstrument;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CompanyDao companyDao;

    @Override
    @Transactional
    public User createUser(String name, String document, int age, String login, String password, Long idCompany, BigDecimal salary) {

        Company company = companyDao.getOne(idCompany);

        User newUser = User.builder().
                name(name).
                document(document).
                age(age).
                username(login).
                password(password).
                salary(salary).
                company(company).
                build();

        return userDao.save(newUser);
    }

    @Override
    public UserVO updateNameUserById(Long id, String name) {

        User user = userDao.getOne(id);
        user.setName(name);

        user = userDao.save(user);

        ModelMapper modelMapper = new ModelMapper();

        UserVO userVO = modelMapper.map(user, UserVO.class);

        return userVO;
    }

    @Override
    public void updateCompanyByUserId(Long id, Long companyId) {
        userDao.updateCompanyByUserId(id, companyId);
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

}
