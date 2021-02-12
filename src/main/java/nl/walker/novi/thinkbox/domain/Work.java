package nl.walker.novi.thinkbox.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "work")
public class Work extends Post {
    private String description;
    private String link;

    public Work() {

    }

    public Work(String description) {
        this.description = description;
    }

    public Work(String title, PostType type, String description, String link) {
        super(title, type);
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
