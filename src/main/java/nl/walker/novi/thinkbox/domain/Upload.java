package nl.walker.novi.thinkbox.domain;
import javax.persistence.*;
import java.io.File;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "upload")
public class Upload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title" )
    private String title;

    @Column(name = "file" )
    private File file;

//    @OneToOne (fetch = FetchType.LAZY, mappedBy = "upload")
//    private Work work;

    public Upload(){
    }

    public Upload(long id, String title, File file) {
        this.id = id;
        this.title = title;
        this.file = file;
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }


}
