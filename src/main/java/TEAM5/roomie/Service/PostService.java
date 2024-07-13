package TEAM5.roomie.Service;

import TEAM5.roomie.Model.Posts;
import TEAM5.roomie.Repository.PostRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final String uploadDir = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static", "images").toString();
    @Autowired
    private final PostRepository postRepository;

    public Posts writePost(@Valid Posts postRequest, MultipartFile photo) throws IOException {
        if (!photo.isEmpty()) {
            String fileName = photo.getOriginalFilename();
            File dest = new File(uploadDir + '/' + fileName);
            photo.transferTo(dest);
            String filePath2 = "images/" + fileName;
            postRequest.setImage(filePath2);
        }

        postRequest.setCreate_at(LocalDateTime.now());
        LocalDateTime meetTime = LocalDateTime.parse(postRequest.getMeet_time(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if (meetTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Meet time cannot be in the past");
        }

        return postRepository.save(postRequest);
    }

    public List<Posts> findAllPosts() {
        return postRepository.findAll();
    }

    public List<Posts> findLaundryPosts() {
        return postRepository.findByTag("laundry");
    }

    public List<Posts> findGroupBuyPosts() {
        return postRepository.findByTag("groupBuyPosts");
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Posts modifyPost(Long post_id, @Valid Posts postRequest) {
        Posts existingPost = postRepository.findById(post_id).orElseThrow(() -> new IllegalArgumentException("Post not found"));

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

        return postRepository.save(existingPost);
    }
}
