package br.com.codenation.aplicacao.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

    private Long id;
    private String name;
    private String document;
    private int age;
    private String username;
    private BigDecimal salary;
    private CompanyVO company;
    private AddressVO address;

}
