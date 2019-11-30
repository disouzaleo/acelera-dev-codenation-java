package br.com.codenation.aplicacao.domain.dao;

import br.com.codenation.aplicacao.domain.entity.Company;
import br.com.codenation.aplicacao.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE company set name = :name WHERE id = :id", nativeQuery = true)
//    User updateNameUserById(@Param("id") Long id, @Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user u set u.company_id = :idCompany WHERE u.id = :id" , nativeQuery = true)
    void updateCompanyByUserId(@Param("id") Long id, @Param("idCompany") Long idCompany);

    User findByName(@Param("name") String name);
}
