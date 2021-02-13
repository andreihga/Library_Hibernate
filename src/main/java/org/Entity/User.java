package org.Entity;

import javax.persistence.*;
@NamedQueries({
        @NamedQuery(name = "login",
                query = "SELECT u from User u where u.username = :username and u.password = :password")
})

@Entity
@Table(name = "users", schema = "library_hibernate")
public class User {
    private static final String PRODUCTS_SEQUENCE = "products_id_sequence";
    private static final String PRODUCTS_GENERATOR = "products_generator";

    @Id
    @SequenceGenerator(name = "PRODUCTS_GENERATOR", sequenceName = PRODUCTS_SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PRODUCTS_GENERATOR)
    String userId;

    @Column (name = "username")
    String username;

    @Column (name = "password")
    String password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
