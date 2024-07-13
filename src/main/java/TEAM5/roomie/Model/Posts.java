package TEAM5.roomie.Model;
import jakarta.persistence.*;
import jakarta.websocket.Encoder;

import java.time.LocalDateTime;


@Entity
@Table(name = "Posts")
public class Posts {

    @Id
    @Column(name = "postid" ,nullable = false, unique = true)
    private int postId;

    @Column(name = "user_name" ,nullable = false)
    private String userName;

    @Column(name = "user_phone" ,nullable = false)
    private String userPhone;

    @Column(name = "title" ,nullable = false)
    private String title;

    @Column(name = "content" ,nullable = false)
    private String content;

    @Column(name = "place" ,nullable = false)
    private String place;

    @Column(name = "date" ,nullable = false)
    private String date;

    @Column(name = "particpant_count" ,nullable = false)
    private int particpantCount;

    @Column(name = "tag" ,nullable = false)
    private String tag;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime create_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;


    @Column(name = "userid", nullable = false)
    private String userId;






}
