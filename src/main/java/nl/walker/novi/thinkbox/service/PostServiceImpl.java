package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.domain.Post;
import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.User;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.PostRepository;
import nl.walker.novi.thinkbox.repository.ProjectRepository;
import nl.walker.novi.thinkbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProjectRepository projectRepository;

    // ## oude getAllPosts() methode
//    @Override
//    public List<Post> getAllPosts() {
//        return postRepository.findAll();
//    }

    @Override
    public List<Post> getAllPostsForProject(Long projectId) {
        Project project = projectRepository.getOne(projectId);
        List<Post> posts = postRepository.findAllByProject(project);
        return posts;
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

    // ## oude savePost methode
    @Override
    public long savePost(Post post, long projectId) {
        try {
            Project project = projectRepository.getOne(projectId);
//        project.getPosts().add(post);
//        projectRepository.save(project);
            post.setProject(project);
            Post newPost = postRepository.save(post);
            return newPost.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        // project ophalen, post toevoegen en dan opslaan
    }


//    @Override
//    public long savePost(Post post, Principal principal) {
//        String currentUserName = ((UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUsername();
//        Optional<User> optUser = userRepository.findByUsername(currentUserName);
//        return postRepository.save(post).getId();
//    }


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
