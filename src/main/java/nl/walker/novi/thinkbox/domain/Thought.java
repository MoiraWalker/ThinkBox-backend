package nl.walker.novi.thinkbox.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Thought extends Post {
    private String description;

    public Thought() {

    }

    public Thought(String description) {
        this.description = description;
    }

    public Thought(String title, PostType type, String description) {
        super(title, type);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
