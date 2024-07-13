package TEAM5.roomie.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostsDTO {
    private String userName;
    private String userPhone;
    private String title;
    private String content;
    private String meetPlace;
    private String meetTime;
    private int maxCount;
    private int userCount;
    private String tag;
    private MultipartFile image;
}
