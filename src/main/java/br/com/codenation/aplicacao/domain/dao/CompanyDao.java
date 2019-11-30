package br.com.codenation.aplicacao.domain.dao;

import br.com.codenation.aplicacao.domain.entity.Company;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyDao extends JpaRepository<Company, Long> {

//    @Query("SELECT c FROM Company WHERE c.name like :name ORDER BY name")
//    List<Company> findAllByNameOrByName(@Param("name") String name, boolean teste); // WITH HIBERNATE

    List<Company> findAllByName(@Param("name") String name);

    List<Company> findAllByNameOrderByName(@Param("name") String name);

    void deleteById(@Param("id") Long id);

}
