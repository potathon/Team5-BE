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
    } // 게시글 전체 조회

    @GetMapping("/laundry")
    public List<Posts> getLaundryPosts() {
        return postService.findLaundryPosts();
    } // 태그가 laundry인 것들을 리스트 형태로 반환

    @GetMapping("/Buy")
    public List<Posts> getGroupBuyPosts() {
        return postService.findGroupBuyPosts();
    } // 태그가 groupBuyPosts인 것들을 리스트 형태로 변환

    @PostMapping("/{post_id}/join")
    public ResponseEntity<?> joinGroup(@PathVariable Long post_id, @RequestBody UsersDTO joinGroupRequest) {
        try {
            userService.createUser(joinGroupRequest, post_id);
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

    @DeleteMapping("/{post_id}/users/{user_id}")
    public ResponseEntity<?> cancelParticipation(@PathVariable Long post_id, @PathVariable Long user_id) {
        try {
            userService.deleteUser(user_id);
            return ResponseEntity.status(200).body("User removed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Failed to remove user: " + e.getMessage());
        }
    }
}
