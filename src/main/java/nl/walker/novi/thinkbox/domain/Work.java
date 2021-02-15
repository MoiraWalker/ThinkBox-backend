package nl.walker.novi.thinkbox.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "work")
public class Work extends Post {
    private String description;
    private String link;
 //   private Upload upload;

//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "work")
//    private Upload upload;

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

//    public Upload getUpload() {
//        return upload;
//    }
//
//    public void setUpload(Upload upload) {
//        this.upload = upload;
//    }
}
