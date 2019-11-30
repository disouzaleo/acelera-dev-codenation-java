package br.com.codenation.aplicacao.domain.entity;

import br.com.codenation.aplicacao.annotation.ColumnAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "document", nullable = false, length = 255)
    private String document;

    @Column(name = "age")
    private int age;

    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "salary", nullable = false, length = 255)
    private BigDecimal salary;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @ColumnAnnotation(text = "Company name is", position = 1)
    @ManyToOne
    @JoinColumn(name = "company_id")
    @Null
    private Company company;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    public User(User user) {
       super();
       this.name = user.getName();
       this.username = user.getUsername();
       this.password = user.getPassword();
       this.age = user.getAge();
       this.document = user.getDocument();
       this.roles = user.getRoles();
    }

    @Override
    public boolean equals(Object object) {
        User obj = (User) object;
        if (obj.getDocument().equalsIgnoreCase(this.getDocument())
                || obj.getName().equalsIgnoreCase(this.getName())
                || obj.getUsername().equals(this.getUsername())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getAge();
    }
}
