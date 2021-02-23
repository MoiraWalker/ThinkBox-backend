package nl.walker.novi.thinkbox.domain;
import javax.persistence.*;
import java.io.File;

@Entity
public class Work extends Post {
    private String description;
    private String link;
    private String fileName;

    @Transient
    private File fileupload;

    public Work() {

    }

    public Work(String title, PostType type, String description, String link, String fileName) {
        super(title, type);
        this.description = description;
        this.link = link;
        this.fileName = fileName;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;

    }

}