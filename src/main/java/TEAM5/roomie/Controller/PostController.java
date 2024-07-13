package TEAM5.roomie.Controller;


import TEAM5.roomie.Model.Posts;
import TEAM5.roomie.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/test")
    ResponseEntity<?> test() {
        Posts posts = postService.test();
        return ResponseEntity.ok(posts);
    }

    @GetMapping
    ResponseEntity<?> allPost() {
        List<Posts> postList = postService.getAllPosts();
        return ResponseEntity.ok(postList);
    }

    @PostMapping
    ResponseEntity<?> createPost(@RequestBody Posts post) {

        postService.savePost(post);

        return ResponseEntity.ok("Post Create Success");
    }

    @DeleteMapping("/{postId}")
    ResponseEntity<?> deletePost(@PathVariable int postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok("Post Delete Success");
    }

    @PutMapping("/{postId}")
    ResponseEntity<?> updatePost(@PathVariable int postId, @RequestBody Posts post) {
        post.setId(postId);
        postService.modifyPost(post);
        return ResponseEntity.ok("Post Update Success");
    }

}
