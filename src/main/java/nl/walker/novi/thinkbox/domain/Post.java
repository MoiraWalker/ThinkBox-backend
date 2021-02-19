package nl.walker.novi.thinkbox.domain;
import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title" )
    private String title;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "post_type" )
    private PostType type;

    // TODO Annotatie en getters en setters
    //    private Project project;

    public Post(){
    }

    public Post(String title, PostType type) {
        this.title = title;
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
}
