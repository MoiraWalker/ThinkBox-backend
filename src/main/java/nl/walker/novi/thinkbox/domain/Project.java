package nl.walker.novi.thinkbox.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "private_view")
    private Boolean privateView;

    @ManyToOne (fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;

    public Project() {
    }

    public Project(Long id, String title, Boolean privateView, User user) {
        this.id = id;
        this.title = title;
        this.privateView = privateView;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Boolean getPrivateView() {
        return privateView;
    }

    public void setPrivateView(Boolean privateView) {
        this.privateView = privateView;
    }
}
