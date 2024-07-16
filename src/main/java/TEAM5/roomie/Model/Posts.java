package TEAM5.roomie.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @Size(max = 10, message = "User name must be less than 10 characters")
    private String user_name;

    @Column(name = "user_phone", nullable = false)
    @Size(max = 20, message = "Phone number must be less than 20 characters")
    private String user_phone;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "Title is mandatory")
    private String title;

    @Column(name = "content", nullable = false)
    @Size(max = 255, message = "Content must be less than 255 characters")
    private String content;

    @Column(name = "meet_place", nullable = false)
    @NotBlank(message = "Meet place is mandatory")
    private String meet_place;

    @Column(name = "meet_time", nullable = false)
    @Future(message = "Meet time must be in the future")
    private String meet_time;

    @Column(name = "user_count", nullable = false)
    private int user_count;

    @Column(name = "max_count", nullable = false)
    @Min(value = 1, message = "Max count must be at least 1")
    private int max_count;

    @Column(name = "tag", nullable = false)
    @NotBlank(message = "Tag is mandatory")
    private String tag;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime create_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    @Column(name = "image", nullable = true)
    private String image;

    @AssertTrue(message = "User count cannot exceed max count")
    public boolean isUserCountValid() {
        return user_count <= max_count;
    }
}