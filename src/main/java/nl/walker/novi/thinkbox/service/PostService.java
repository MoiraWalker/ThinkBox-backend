
package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Post;
import java.util.List;

public interface PostService {

    List<Post> getAllPostsForProject(Long projectId);
    long savePost(Post post, long projectId);
    Post getPostById(long id);
    void deletePost(long id);
    void updatePost(long id, Post post );
}