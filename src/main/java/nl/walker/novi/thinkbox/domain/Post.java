package nl.walker.novi.thinkbox.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title" )
    private String title;

    @Column(name = "current_project_id" )
    private long currentProjectId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "post_type" )
    private PostType type;

    @ManyToOne
    @JsonBackReference
    private Project project;

    public Post(){
    }

    public Post(long id, String title, long currentProjectId, PostType type) {
        this.id = id;
        this.title = title;
        this.currentProjectId = currentProjectId;
        this.type = type;
    }

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


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public long getCurrentProjectId() {
        return currentProjectId;
    }

    public void setCurrentProjectId(long currentProjectId) {
        this.currentProjectId = currentProjectId;
    }
}
