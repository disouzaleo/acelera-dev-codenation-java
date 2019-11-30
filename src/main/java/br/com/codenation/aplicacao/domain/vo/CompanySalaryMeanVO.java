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
public class CompanySalaryMeanVO {
    private String name;
    private BigDecimal salaryMean;
}
