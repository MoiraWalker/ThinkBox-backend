package nl.walker.novi.thinkbox.controller;

import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.User;
import nl.walker.novi.thinkbox.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/projects")
    public ResponseEntity<Object> getAllProjects(Principal principal) {
        List<Project> projects = projectService.getAllProjectsForUser(principal);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/projects/{id}")
    public ResponseEntity<Object> getProjectById(@PathVariable("id") long id) {
        Project project = projectService.getProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('USER')")
    @DeleteMapping(value = "/projects/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable("id") long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@PreAuthorize("hasRole('USER')")
    @PostMapping(value = "/projects")
    public ResponseEntity<Object> saveProjects(@RequestBody Project project) {
        long newId = projectService.saveProject(project);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    // @PreAuthorize("hasRole('USER')")
    @PutMapping(value = "/projects/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable("id") int id, @RequestBody Project project) {
        projectService.updateProject(id, project);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}