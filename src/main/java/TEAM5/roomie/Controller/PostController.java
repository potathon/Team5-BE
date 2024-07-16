package TEAM5.roomie.Controller;

import TEAM5.roomie.Dto.PostsDTO;
import TEAM5.roomie.Dto.UsersDTO;
import TEAM5.roomie.Model.Posts;
import TEAM5.roomie.Model.Users;
import TEAM5.roomie.Service.PostService;
import TEAM5.roomie.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private final PostService postService;

    @Autowired
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> post(@ModelAttribute PostsDTO postRequest) {
        MultipartFile image = postRequest.getImage() != null ? postRequest.getImage() : null;
        try {
            Posts post = postService.writePost(
                    postRequest.getTitle(),
                    postRequest.getUser_name(),
                    postRequest.getUser_phone(),
                    postRequest.getTag(),
                    postRequest.getMeet_time(),
                    postRequest.getMeet_place(),
                    postRequest.getMax_count(),
                    image,
                    postRequest.getContent()
            );

            return ResponseEntity.status(201).body(post);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Failed to create post: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Posts> getAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/laundry")
    public List<Posts> getLaundryPosts() {
        return postService.findLaundryPosts();
    }

    @GetMapping("/buy")
    public List<Posts> getGroupBuyPosts() {
        return postService.findGroupBuyPosts();
    }

    @PostMapping("/{post_id}/join")
    public ResponseEntity<?> joinGroup(@PathVariable Long post_id, @RequestBody UsersDTO usersDTO) {
        try {
            userService.createUser(usersDTO, post_id);
            return ResponseEntity.status(201).body("User added successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Failed to join group: " + e.getMessage());
        }
    }

    @GetMapping("/{post_id}/users")
    public ResponseEntity<List<Users>> getUsersByPostId(@PathVariable Long post_id) {
        List<Users> users = userService.getUsersByPostId(post_id);
        return ResponseEntity.status(200).body(users);
    }

    @DeleteMapping("/{post_id}/delete")
    public ResponseEntity<?> deletePost(@PathVariable Long post_id, @RequestParam String user_name, @RequestParam String phone) {
        try {
            // 작성자가 맞는지 확인
            Posts post = postService.findById(post_id).orElseThrow(() -> new IllegalArgumentException("Post not found"));
            if (post.getUser_name().equals(user_name) && post.getUser_phone().equals(phone)) {
                userService.deletePost(post_id);
                return ResponseEntity.status(200).body("Post deleted successfully");
            } else {
                return ResponseEntity.status(403).body("Unauthorized to delete this post");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Failed to delete post: " + e.getMessage());
        }
    }


    @PutMapping("/{post_id}")
    public ResponseEntity<?> updatePost(@PathVariable Long post_id, @RequestBody Posts postRequest) {
        try {
            Posts updatedPost = postService.modifyPost(post_id, postRequest);
            return ResponseEntity.status(200).body(updatedPost);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Failed to update post: " + e.getMessage());
        }
    }

    @DeleteMapping("/{post_id}/users/cancel")
    public ResponseEntity<?> cancelParticipation(@PathVariable Long post_id, @RequestParam String user_name, @RequestParam String phone) {
        try {
            userService.cancelParticipation(post_id, user_name, phone);
            return ResponseEntity.status(200).body("User removed successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Failed to remove user: " + e.getMessage());
        }
    }


    private Posts convertToEntity(PostsDTO postRequest) {
        Posts post = new Posts();
        post.setTitle(postRequest.getTitle());
        post.setUser_name(postRequest.getUser_name());
        post.setUser_phone(postRequest.getUser_phone());
        post.setTag(postRequest.getTag());
        post.setMeet_time(postRequest.getMeet_time());
        post.setMeet_place(postRequest.getMeet_place());
        post.setMax_count(postRequest.getMax_count());
        post.setContent(postRequest.getContent());
        return post;
    }
}
