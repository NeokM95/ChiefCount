package nl.koenm.chiefcount.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Inheritance
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class ApplicationUser {


    @Id
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private int plusMinus;
    @Column
    private int divide;
    @Column
    private int multiply;

    private boolean enabled;

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public void addAuthority(String authorityString) {
        this.authorities.add(new Authority(this.username, authorityString));
    }
    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }
    public void removeAuthority(String authorityString) {
        this.authorities.removeIf(authority -> authority.getAuthority().equalsIgnoreCase(authorityString));
    }

}
