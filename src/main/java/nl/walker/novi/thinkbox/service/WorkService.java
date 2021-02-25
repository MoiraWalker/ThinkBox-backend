package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Work;
import java.util.List;

public interface WorkService {

    List<Work> getAllWorks();
    long saveWork(Work work);
    Work getWorkById(long id);
    void deleteWork(long id);
    void updateWork(long id, Work work);
}
