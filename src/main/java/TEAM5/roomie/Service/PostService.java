package TEAM5.roomie.Service;

import TEAM5.roomie.Model.Posts;
import TEAM5.roomie.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    public Posts test(){
        return postRepository.test();
    }

    public List<Posts> getAllPosts(){
        return postRepository.findAll();
    }

    public void deletePost(int id){
        postRepository.deleteById(id);
    }

    public void modifyPost(Posts post){
        postRepository.updatePost(post);
    }
}
