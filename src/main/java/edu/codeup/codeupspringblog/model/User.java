package edu.codeup.codeupspringblog.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) unsigned NOT NULL AUTO_INCREMENT")
    private Long id;

    @Column(columnDefinition = "varchar(200) unsigned")
    private String username;

    @Column(columnDefinition = "varchar(200)")
    private String email;

    @Column(columnDefinition = "varchar(10)")
    private String password;


    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Post> posts;

    public User() {
    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
