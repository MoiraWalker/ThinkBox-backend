package nl.walker.novi.thinkbox.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title" )
    private String title;

    @Column(name = "project_id" )
    private String projectId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "post_type" )
    private PostType type;

    // TODO Annotatie en getters en setters
    //    private Project project;

    // ### relatie pogingen
//    @ManyToOne (fetch = FetchType.EAGER)
//    @JsonIgnore
//    private Project project;

//    @OneToOne(mappedBy = "project")
//    private Project project;

    public Post(){
    }

    public Post(long id, String title, String projectId, PostType type) {
        this.id = id;
        this.title = title;
        this.projectId = projectId;
        this.type = type;
    }

    // ### constructor met project
//    public Post(long id, String title, String projectId, PostType type, Project project) {
//        this.id = id;
//        this.title = title;
//        this.projectId = projectId;
//        this.type = type;
//        this.project = project;
//    }

    public PostType getType() {
        return type;
    }

    public void setType(PostType type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
}
