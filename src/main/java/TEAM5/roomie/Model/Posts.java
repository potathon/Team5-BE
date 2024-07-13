package TEAM5.roomie.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String user_name;

    @Column(name = "user_phone", nullable = false)
    private String user_phone;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "meet_place", nullable = false)
    private String meet_place;

    @Column(name = "meet_time", nullable = false)
    private String meet_time;

    @Column(name = "user_count", nullable = false)
    private int user_count;

    @Column(name = "max_count", nullable = false)
    private int max_count;

    @Column(name = "tag", nullable = false)
    private String tag;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime create_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    @Column(name = "image")
    private String image;
}