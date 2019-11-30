package br.com.codenation.aplicacao.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "document", nullable = false, length = 255)
    private String document;

    @Column(name = "vacancies")
    private int vacancies;

    @Column(name = "site", nullable = false, length = 255)
    private String site;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<User> listUser;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object object) {
        Company obj = (Company) object;
        if (obj.getDocument().equalsIgnoreCase(this.getDocument())) {
            return true;
        }
        if (obj.getName().equalsIgnoreCase(this.getName())) {
            return true;
        }
        return false;
    }

}
