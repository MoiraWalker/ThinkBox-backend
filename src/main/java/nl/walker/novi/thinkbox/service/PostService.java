package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Post;
import java.util.List;

public interface PostService {

    List<Post> getAllPostsForProject(Long projectId);
    Post getPostById(long id);
    void deletePost(long id);
    long savePost(Post post, long projectId);
    void updatePost(long id, Post post );
}
