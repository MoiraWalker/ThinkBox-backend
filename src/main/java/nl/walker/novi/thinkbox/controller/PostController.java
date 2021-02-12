package nl.walker.novi.thinkbox.controller;
import nl.walker.novi.thinkbox.domain.Post;
import nl.walker.novi.thinkbox.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/posts")
    public ResponseEntity<Object> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<Object> getPostsById(@PathVariable("id") long id) {
        Post post = postService.getPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping(value = "/posts/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable("id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/posts")
    public ResponseEntity<Object> savePosts(@RequestBody Post post) {
        long newId = postService.savePost(post);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/posts/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable("id") int id, @RequestBody Post post) {
        postService.updatePost(id, post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
