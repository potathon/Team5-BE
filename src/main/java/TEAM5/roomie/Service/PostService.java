package TEAM5.roomie.Service;

import TEAM5.roomie.Model.Posts;
import TEAM5.roomie.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PostService {


    @Autowired
    private PostRepository postRepository;

    public Posts writePost(String title, String tag, String meet_date, String meet_place, int max_recruit, MultipartFile image){
        Posts posts = new Posts();
        posts.setTitle(title);
        posts.setTag(tag);
        posts.setDate(meet_date);
        posts.setPlace(meet_place);
        posts.setMax_count(max_recruit);
        posts.setImage(String.valueOf(image));

        return postRepository.save(posts);
    }
}
