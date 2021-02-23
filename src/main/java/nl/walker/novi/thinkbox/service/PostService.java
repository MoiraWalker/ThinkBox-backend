package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Post;

import java.security.Principal;
import java.util.List;

public interface PostService {

    List<Post> getAllPosts(Principal principal);
    Post getPostById(long id);
    void deletePost(long id);
    long savePost(Post post, Principal principal);
    void updatePost(long id, Post post );
}
