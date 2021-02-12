package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Work;
import java.util.List;

public interface WorkService {

    List<Work> getAllWorks();
    Work getWorkById(long id);
    void deleteWork(long id);
    long saveWork(Work work);
    void updateWork(long id, Work work);
}
