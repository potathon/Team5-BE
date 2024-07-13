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
    private String user_name;

    @Column(name = "user_phone")
    private String user_phone;

    private String title;
    private String content;

    @Column(name = "meet_place")
    private String meet_place;

    @Column(name = "meet_time")
    private String meet_time;

    @Column(name = "max_count")
    private int max_count;

    @Column(name = "user_count")
    private int user_count;

    private String tag;

    @Lob
    private byte[] image;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "deleted_at")
    private String deleted_at;

}
