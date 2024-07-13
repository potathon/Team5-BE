package TEAM5.roomie.Controller;

import TEAM5.roomie.Model.Posts;
import TEAM5.roomie.Repository.ParticpantsRepository;
import TEAM5.roomie.Repository.PostRepository;
import TEAM5.roomie.Service.ParticpantsService;
import TEAM5.roomie.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController

public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ParticpantsRepository particpantsRepository;

    @Autowired
    private ParticpantsService particpantsService;
    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody Map<String, Object> postRequest) {


        try {
            String title = (String) postRequest.get("title");
            String tag = (String) postRequest.get("tag");
            String meet_date = (String) postRequest.get("meet_date");
            String meet_place = (String) postRequest.get("meet_place");
            Integer max_recruit = (Integer) postRequest.get("max_recruit");
            MultipartFile image = (MultipartFile) postRequest.get("image");

            Posts post = postService.writePost(title, tag, meet_date, meet_place, max_recruit, image);

            return ResponseEntity.status(201).body(post);
        } catch (Exception e) {
            // 예외 처리 - 예외의 유형에 따라 다른 상태 코드를 반환할 수 있습니다.
            return ResponseEntity.status(400).body("Failed to create post: " + e.getMessage());
        }
    }
    @GetMapping("/getAllPosts")
    public List<Posts> getAllPosts(){

        return postRepository.findAll();

    } // 게시글 전체 조회
    @GetMapping("/laundryPosts")
    public List<Posts> getLaundryPosts(){

        return postRepository.findByTag("laundry");

    } // 태그가 laundry인 것들을 리스트 형태로 반환

    @GetMapping("/groupBuyPosts")
    public List<Posts> getGroupByPosts(){

        return postRepository.findByTag("groupBuyPosts");

    } // 태그가 groupBuyPosts인 것들을 리스트 형태로 변환

    @PostMapping("/post/{postId}")
    public ResponseEntity<?> joinGroup(@PathVariable int postId,@RequestBody Map<String,Object> PostRequest){
        String user_name = (String)PostRequest.get("user_name");
        String user_phone = (String)PostRequest.get("user_phone");

        /* particpantsService.joinGroup(postId,user_name,user_phone); */



    }

}
