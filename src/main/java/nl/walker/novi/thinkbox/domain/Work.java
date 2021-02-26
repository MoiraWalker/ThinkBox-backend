package nl.walker.novi.thinkbox.domain;
import javax.persistence.*;
import java.io.File;

@Entity
public class Work extends Post {
    private String description;
    private String link;
    private String fileUpload;

    public Work() {

    }

    public Work(String description) {
        this.description = description;
    }

    public Work(String title, PostType type, String description, String link, String fileUpload) {
        super(title, type);
        this.description = description;
        this.link = link;
        this.fileUpload = fileUpload;
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

    public String getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(String fileUpload) {
        this.fileUpload = fileUpload;
    }
}
