package nl.walker.novi.thinkbox.domain;
import javax.persistence.Entity;

@Entity
public class Thought extends Post {
    private String description;

    public Thought() {

    }

    public Thought(long id, String title, long currentProjectId, PostType type, String description) {
        super(id, title, currentProjectId, type);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}