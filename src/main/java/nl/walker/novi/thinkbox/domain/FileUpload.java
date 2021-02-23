package nl.walker.novi.thinkbox.domain;
import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "app_file_upload")
public class FileUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "private_view")
    File fileupload;

    public FileUpload() {
    }

    public FileUpload(Long id, String title, File fileupload) {
        this.id = id;
        this.title = title;
        this.fileupload = fileupload;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getFileUpload() {
        return fileupload;
    }

    public void setFileUpload(File fileupload) {
        this.fileupload = fileupload;
    }

}
