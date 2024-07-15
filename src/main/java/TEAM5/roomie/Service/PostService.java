package TEAM5.roomie.Service;

import TEAM5.roomie.Model.Posts;
import TEAM5.roomie.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final String uploadDir = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static", "images").toString();
    @Autowired
    private final PostRepository postRepository;

    public Posts writePost(String title, String user_name, String user_phone, String tag, String meet_time, String meet_place, int max_count, MultipartFile photo, String content) throws IOException {
        Posts posts = new Posts();

        if(photo != null && !photo.isEmpty()){
            String fileName = photo.getOriginalFilename();
            File dest = new File( uploadDir + '/' + fileName);
            photo.transferTo(dest);
            String filePath2 = "images/" + fileName;
            posts.setImage(filePath2);
        }


        posts.setTitle(title);
        posts.setUser_name(user_name);
        posts.setUser_phone(user_phone);
        posts.setTag(tag);
        posts.setMeet_time(meet_time);
        posts.setMeet_place(meet_place);
        posts.setMax_count(max_count);
        posts.setContent(content);
        posts.setCreate_at(LocalDateTime.now());


        return postRepository.save(posts);
    }

    public List<Posts> findAllPosts(){
        return postRepository.findAll();
    }
    public List<Posts> findLaundryPosts(){
        return postRepository.findByTag("laundry");
    }

    public List<Posts> findGroupBuyPosts(){
        return postRepository.findByTag("buy");
    }

    public void deletePost(int id){
        postRepository.deleteById(id);
    }

    public void modifyPost(Posts post){
    }
}
