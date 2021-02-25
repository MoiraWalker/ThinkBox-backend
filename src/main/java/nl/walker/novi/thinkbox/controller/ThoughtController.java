package nl.walker.novi.thinkbox.controller;
import nl.walker.novi.thinkbox.domain.Thought;
import nl.walker.novi.thinkbox.service.ThoughtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class ThoughtController {

    @Autowired
    private ThoughtService thoughtService;

    // ### oude getAllThoughts
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    @GetMapping(value = "/thoughts")
//    public ResponseEntity<Object> getAllThoughts() {
//        List<Thought> thoughts = thoughtService.getAllThoughts();
//        return new ResponseEntity<>(thoughts, HttpStatus.OK);
//    }

    // ## oude saveThought
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    @PostMapping(value = "/thoughts")
//    public ResponseEntity<Object> saveThought(@RequestBody Thought thought) {
//        long newId = thoughtService.saveThought(thought);
//        return new ResponseEntity<>(newId, HttpStatus.CREATED);
//    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(value = "/thoughts/project/{projectId}")
    public ResponseEntity<Object> getAllThoughtsForProject(@PathVariable("projectId") long projectId) {
        List<Thought> thoughts = thoughtService.getAllThoughtsForProject(projectId);
        return new ResponseEntity<>(thoughts, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping(value = "/thoughts")
    public ResponseEntity<Object> saveThought(@RequestBody Thought thought) {
        long newId = thoughtService.saveThought(thought, thought.getCurrentProjectId());
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(value = "/thoughts/{id}")
    public ResponseEntity<Object> getThoughtsById(@PathVariable("id") long id) {
        Thought thought = thoughtService.getThoughtById(id);
        return new ResponseEntity<>(thought, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping(value = "/thoughts/{id}")
    public ResponseEntity<Object> deleteThought(@PathVariable("id") long id) {
        thoughtService.deleteThought(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping(value = "/thoughts/{id}")
    public ResponseEntity<Object> updateThought(@PathVariable("id") int id, @RequestBody Thought thought) {
        thoughtService.updateThought(id, thought);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
