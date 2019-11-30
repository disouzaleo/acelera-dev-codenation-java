package br.com.codenation.aplicacao.service.impl;

import br.com.codenation.aplicacao.domain.dao.AddressDao;
import br.com.codenation.aplicacao.domain.dao.CompanyDao;
import br.com.codenation.aplicacao.domain.entity.Address;
import br.com.codenation.aplicacao.domain.entity.Company;
import br.com.codenation.aplicacao.domain.entity.User;
import br.com.codenation.aplicacao.domain.vo.CompanySalaryMeanVO;
import br.com.codenation.aplicacao.domain.vo.CompanyVO;
import br.com.codenation.aplicacao.service.CompanyService;
import br.com.codenation.aplicacao.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public CompanyVO createCompany(CompanyVO companyVO) {

//        Company company = companyDao.save(modelMapper.map(CompanyVO, Company.class))
        //return modelMapper.map(company, CompanyVo.class)

        ModelMapper modelMapper = new ModelMapper();

        Address address = new Address().builder()
                .zipCode(companyVO.getAddress().getZipCode())
                .street(companyVO.getAddress().getStreet())
                .number(companyVO.getAddress().getNumber())
                .district(companyVO.getAddress().getDistrict())
                .city(companyVO.getAddress().getCity())
                .country(companyVO.getAddress().getCountry())
                .build();

        address = addressDao.save(address);

        Company company = Company.builder().
                name(companyVO.getName()).
                document(companyVO.getDocument()).
                vacancies(companyVO.getVacancies()).
                site(companyVO.getSite()).
                address(address).
                build();

        company = companyDao.save(company);

        CompanyVO companyVoReturn = modelMapper.map(company, CompanyVO.class);

        return companyVoReturn;
    }

    @Override
    public void deleteCompany(Company company) {
        companyDao.delete(company);
    }

    @Override
    public void deleteById(Long id) {
        companyDao.deleteById(id);
    }

    @Override
    public List<CompanyVO> findAllByName(String name) {
        List<CompanyVO> companyVOList = new ArrayList<>();
        List<Company> companies = companyDao.findAllByName(name);
        companies.forEach(company -> {
            CompanyVO vo = new CompanyVO();
            vo.setId(company.getId());
            vo.setDocument(company.getDocument());
            vo.setSite(company.getSite());
            vo.setVacancies(company.getVacancies());
            companyVOList.add(vo);
        });
        return companyVOList;
    }

    @Override
    public List<CompanySalaryMeanVO> findAllCompaniesSalaryMeans() {
        List<CompanySalaryMeanVO> companyVOList = new ArrayList<>();
        List<Company> companies = companyDao.findAll();
        companies.forEach(company -> {
            CompanySalaryMeanVO vo = new CompanySalaryMeanVO();
            vo.setName(company.getName());
            vo.setSalaryMean(companySalaryMean(company.getId()));
            companyVOList.add(vo);
        });
        return companyVOList;
    }

    @Override
    public BigDecimal companySalaryMean(Long companyId) {
        List<User> users = userService.findUsersByCompanyId(companyId);
        BigDecimal salaryMean = new BigDecimal(0L);
        for (User user : users) {
            salaryMean.add(user.getSalary());
        }

        return salaryMean.divide(new BigDecimal(users.size()));
    }

}
