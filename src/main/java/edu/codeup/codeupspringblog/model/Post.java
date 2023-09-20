package edu.codeup.codeupspringblog.model;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String title;
    @Column(nullable=false, columnDefinition = "TEXT")
    private String content;
    // getters and setters

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;


public Post(){

}
    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Post(String title, String content) {
    }

    public Post(String title, String content, User hardCodedUser) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

