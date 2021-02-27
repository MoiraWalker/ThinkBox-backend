package nl.walker.novi.thinkbox.domain;
import javax.persistence.*;

@Entity
public class Work extends Post {
    private String description;
    private String link;

    public Work() {

    }

    public Work(long id, String title, long currentProjectId, PostType type, String description, String link) {
        super(id, title, currentProjectId, type);
        this.description = description;
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
