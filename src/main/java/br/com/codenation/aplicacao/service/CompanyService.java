package br.com.codenation.aplicacao.service;

import br.com.codenation.aplicacao.domain.entity.Company;
import br.com.codenation.aplicacao.domain.vo.CompanySalaryMeanVO;
import br.com.codenation.aplicacao.domain.vo.CompanyVO;
import br.com.codenation.aplicacao.exception.EmpresaException;

import java.math.BigDecimal;
import java.util.List;

public interface CompanyService {

    CompanyVO createCompany(CompanyVO companyVO);

    void deleteCompany(Company company);

    void deleteById(Long id);

    List<CompanyVO> findAllByName(String name);

    List<CompanySalaryMeanVO> findAllCompaniesSalaryMeans();

    BigDecimal companySalaryMean(Long companyId);
}
