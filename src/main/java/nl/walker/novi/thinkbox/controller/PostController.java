package nl.walker.novi.thinkbox.controller;
import nl.walker.novi.thinkbox.domain.Post;
import nl.walker.novi.thinkbox.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    private PostService postService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(value = "/posts")
    public ResponseEntity<Object> getAllPosts(Principal principal) {
        List<Post> posts = postService.getAllPosts(principal);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<Object> getPostsById(@PathVariable("id") long id) {
        Post post = postService.getPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping(value = "/posts/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable("id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping(value = "/posts")
    public ResponseEntity<Object> savePost(@RequestBody Post post, Principal principal) {
        long newId = postService.savePost(post, principal);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping(value = "/posts/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable("id") int id, @RequestBody Post post) {
        postService.updatePost(id, post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
