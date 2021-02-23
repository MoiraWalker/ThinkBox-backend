package nl.walker.novi.thinkbox.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Thought extends Post {
    private String description;

    public Thought() {

    }

    public Thought(long id, String title, String projectId, PostType type, String description) {
        super(id, title, projectId, type);
        this.description = description;
    }

    //  ##### constructor met project
//    public Thought(long id, String title, String projectId, PostType type, Project project, String description) {
//        super(id, title, projectId, type, project);
//        this.description = description;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
