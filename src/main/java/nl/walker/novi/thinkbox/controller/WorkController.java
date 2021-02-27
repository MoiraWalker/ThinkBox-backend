package nl.walker.novi.thinkbox.controller;
import nl.walker.novi.thinkbox.domain.Work;
import nl.walker.novi.thinkbox.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkController {

    @Autowired
    private WorkService workService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(value = "/works/project/{projectId}")
    public ResponseEntity<Object> getAllWorksForProject(@PathVariable("projectId") long projectId) {
        List<Work> works = workService.getAllWorksForProject(projectId);
        return new ResponseEntity<>(works, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping(value = "/works")
    public ResponseEntity<Object> saveWork(@RequestBody Work work) {
        long newId = workService.saveWork(work, work.getCurrentProjectId());
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(value = "/works/{id}")
    public ResponseEntity<Object> getWorksById(@PathVariable("id") long id) {
        Work work = workService.getWorkById(id);
        return new ResponseEntity<>(work, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping(value = "/works/{id}")
    public ResponseEntity<Object> deleteWorks(@PathVariable("id") long id) {
        workService.deleteWork(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping(value = "/works/{id}")
    public ResponseEntity<Object> updateWork(@PathVariable("id") int id, @RequestBody Work work) {
        workService.updateWork(id, work);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}