package it.sevenbits.conferences.domain;

import java.util.Set;

import javax.persistence.*;

/**
 * POJO class for role model.
 */
@Entity
@Table(name = "role")
public class Role {

    private Long id;
    private String role;
    private Set<User> userRoles;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            }
    )
    public Set<User> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(final Set<User> userRoles) {
        this.userRoles = userRoles;
    }

}
