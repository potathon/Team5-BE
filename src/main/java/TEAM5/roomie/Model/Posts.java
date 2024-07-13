package TEAM5.roomie.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
@Data
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_phone")
    private String userPhone;

    private String title;
    private String content;

    @Column(name = "meet_place")
    private String meetPlace;

    @Column(name = "meet_time")
    private String meetTime;

    @Column(name = "max_count")
    private int maxCount;

    @Column(name = "user_count")
    private int userCount;

    private String tag;
    private byte[] image;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @Column(name = "deleted_at")
    private String deletedAt;
}
