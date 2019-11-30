package br.com.codenation.aplicacao.domain.vo;

import br.com.codenation.aplicacao.domain.entity.Address;
import br.com.codenation.aplicacao.domain.entity.Company;
import br.com.codenation.aplicacao.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyVO {

    private Long id;
    private String name;
    private String document;
    private int vacancies;
    private String site;
    private AddressVO address;

}
