package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Work;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface WorkService {

    void uploadFile(MultipartFile file) throws IOException;
    List<Work> getAllWorks();
    Work getWorkById(long id);
    void deleteWork(long id);
    long saveWork(Work work);
    void updateWork(long id, Work work);
}
