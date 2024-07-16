package TEAM5.roomie.Service;

import TEAM5.roomie.Model.Posts;
import TEAM5.roomie.Repository.PostRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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
            File dest = new File(uploadDir + '/' + fileName);
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
        posts.setUser_count(0); // 초기 사용자 수 설정

        LocalDateTime meetTime = LocalDateTime.parse(meet_time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if (meetTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Meet time cannot be in the past");
        }

        return postRepository.save(posts);
    }

    public List<Posts> findAllPosts() {
        return postRepository.findAll();
    }

    public List<Posts> findLaundryPosts() {
        return postRepository.findByTag("laundry");
    }

    public List<Posts> findGroupBuyPosts(){
        return postRepository.findByTag("buy");
    }

    public Optional<Posts> findById(Long postId) {
        return postRepository.findById(postId);
    }


    @Transactional
    public void deletePostIfAuthorized(Long postId, String userName, String phone) {
        Posts post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));

        if (post.getUser_name().equals(userName) && post.getUser_phone().equals(phone)) {
            postRepository.delete(post);
        } else {
            throw new IllegalArgumentException("Unauthorized user");
        }
    }

    @Transactional
    public Posts modifyPost(Long postId, @Valid Posts postRequest) {
        Posts existingPost = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        updatePostDetails(existingPost, postRequest);
        return postRepository.save(existingPost);
    }

    private void updatePostDetails(Posts existingPost, Posts postRequest) {
        LocalDateTime meetTime = LocalDateTime.parse(postRequest.getMeet_time(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if (meetTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Meet time cannot be in the past");
        }

        existingPost.setTitle(postRequest.getTitle());
        existingPost.setUser_name(postRequest.getUser_name());
        existingPost.setUser_phone(postRequest.getUser_phone());
        existingPost.setTag(postRequest.getTag());
        existingPost.setMeet_time(postRequest.getMeet_time());
        existingPost.setMeet_place(postRequest.getMeet_place());
        existingPost.setMax_count(postRequest.getMax_count());
        existingPost.setContent(postRequest.getContent());
        existingPost.setUpdated_at(LocalDateTime.now());
    }
}
