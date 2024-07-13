package TEAM5.roomie.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsDTO {
    private Long id;
    private String title;
    private String user_name;
    private String user_phone;
    private String tag;
    private String meet_time;
    private String meet_place;
    private Integer user_count;
    private Integer max_count;
    private MultipartFile image;
    private String content;
}