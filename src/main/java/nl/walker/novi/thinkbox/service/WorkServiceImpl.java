package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.Work;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.ProjectRepository;
import nl.walker.novi.thinkbox.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Work> getAllWorksForProject(Long projectId) {
        Project project = projectRepository.getOne(projectId);
        List<Work> works = workRepository.findAllByProject(project);
        return works;
    }

    @Override
    public long saveWork(Work work, long projectId) {
        try {
            Project project = projectRepository.getOne(work.getCurrentProjectId());
            work.setProject(project);
            Work newWork = workRepository.save(work);
            return newWork.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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
                existingWork.setFileUpload(work.getFileUpload());
                existingWork.setCurrentProjectId(work.getCurrentProjectId());
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