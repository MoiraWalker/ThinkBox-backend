package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.domain.Post;
import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
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
    public long savePost(Post post) {
        Post newPost = postRepository.save(post);
        return newPost.getId();
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
