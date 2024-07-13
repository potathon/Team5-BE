package TEAM5.roomie.Controller;

import TEAM5.roomie.Model.Posts;
import TEAM5.roomie.Repository.PostRepository;
import TEAM5.roomie.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController

public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public Posts post(@RequestBody Map<String, Object> postRequest){




        String title = (String)postRequest.get("title");
        String tag = (String)postRequest.get("tag");
        String meet_date = (String)postRequest.get("meet_date");
        String meet_place = (String)postRequest.get("meet_place");
        Integer max_recruit = (Integer)postRequest.get("max_recruit");
        MultipartFile image = (MultipartFile)postRequest.get("image");

        return postService.writePost(title,tag,meet_date,meet_place,max_recruit,image);

    }


}
