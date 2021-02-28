package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.User;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.ProjectRepository;
import nl.walker.novi.thinkbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Project> getAllProjectsForUser(Principal principal) {
        Long userId = ((UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getId();
        List<Project> projects = projectRepository.findAllByUserId(userId);
        return projects;
    }

    @Override
    public long saveProject(Project project, Principal principal) {
        String currentUserName = ((UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUsername();
        Optional<User> optUser = userRepository.findByUsername(currentUserName);
        project.setUser(optUser.get());

        return projectRepository.save(project).getId();
    }


    @Override
    public Project getProjectById(long id) {
        if (projectRepository.existsById(id)) {
            return projectRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteProject(long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }


    @Override
    public void updateProject(long id, Project project) {
        if (projectRepository.existsById(id)) {
            try {
                Project existingProject = projectRepository.findById(id).orElse(null);
                existingProject.setTitle(project.getTitle());
                existingProject.setPrivateView(project.getPrivateView());
                projectRepository.save(existingProject);
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
