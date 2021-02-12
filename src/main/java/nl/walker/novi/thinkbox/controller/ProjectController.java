package nl.walker.novi.thinkbox.controller;
import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/projects")
    public ResponseEntity<Object> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping(value = "/projects/{id}")
    public ResponseEntity<Object> getProjectById(@PathVariable("id") long id) {
        Project project = projectService.getProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping(value = "/projects/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable("id") long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/projects")
    public ResponseEntity<Object> saveProjects(@RequestBody Project project) {
        long newId = projectService.saveProject(project);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/projects/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable("id") int id, @RequestBody Project project) {
        projectService.updateProject(id, project);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
