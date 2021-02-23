package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Project;

import java.security.Principal;
import java.util.List;

public interface ProjectService {

    List<Project> getAllProjectsForUser(Principal principal);
    Project getProjectById(long id);
    void deleteProject(long id);
    long saveProject(Project project, Principal principal);
    void updateProject(long id, Project project);
}
