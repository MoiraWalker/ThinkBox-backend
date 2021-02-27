package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Post;
import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.PostRepository;
import nl.walker.novi.thinkbox.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Post> getAllPostsForProject(Long projectId) {
        Project project = projectRepository.getOne(projectId);
        List<Post> posts = postRepository.findAllByProject(project);
        return posts;
    }

    @Override
    public long savePost(Post post, long projectId) {
        try {
            Project project = projectRepository.getOne(post.getCurrentProjectId());
            post.setProject(project);
            Post newPost = postRepository.save(post);
            return newPost.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Post getPostById(long id) {
        if (postRepository.existsById(id)) {
            return postRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deletePost(long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updatePost(long id, Post post) {
        if (postRepository.existsById(id)) {
            try {
                Post existingPost = postRepository.findById(id).orElse(null);
                existingPost.setTitle(post.getTitle());
                existingPost.setType(post.getType());
                postRepository.save(existingPost);
            }
            catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
    }

}
