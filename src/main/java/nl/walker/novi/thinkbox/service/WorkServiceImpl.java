package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.domain.Work;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkRepository workRepository;

    @Override
    public List<Work> getAllWorks() {
        return workRepository.findAll();
    }

    @Override
    public long saveWork(Work work) {
        Work newWork = workRepository.save(work);
        return newWork.getId();
    }


    @Override
    public Work getWorkById(long id) {
        if (workRepository.existsById(id)) {
            return workRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteWork(long id) {
        if (workRepository.existsById(id)) {
            workRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updateWork(long id, Work work) {
        if (workRepository.existsById(id)) {
            try {
                Work existingWork = workRepository.findById(id).orElse(null);
                existingWork.setTitle(work.getTitle());
                existingWork.setType(work.getType());
                existingWork.setLink(work.getLink());
                existingWork.setDescription(work.getDescription());
                workRepository.save(existingWork);
            }
            catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
    }

}
