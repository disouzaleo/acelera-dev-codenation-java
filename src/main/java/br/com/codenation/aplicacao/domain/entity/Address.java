package br.com.codenation.aplicacao.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "zip_code", nullable = false, length = 255)
    private String zipCode;

    @Column(name = "street", nullable = false, length = 255)
    private String street;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "district", nullable = false, length = 255)
    private String district;

    @Column(name = "city", nullable = false, length = 255)
    private String city;

    @Column(name =  "country", nullable = false, length = 255)
    private String country;

}
