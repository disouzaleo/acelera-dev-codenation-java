package br.com.codenation.aplicacao.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressVO {

    private Long id;
    private String zipCode;
    private String street;
    private Integer number;
    private String district;
    private String city;
    private String country;

}
