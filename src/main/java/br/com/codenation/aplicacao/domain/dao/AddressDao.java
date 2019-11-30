package br.com.codenation.aplicacao.domain.dao;

import br.com.codenation.aplicacao.domain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Long> {
}
