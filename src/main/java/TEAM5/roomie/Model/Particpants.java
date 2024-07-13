package TEAM5.roomie.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "Particpants")
public class Particpants{
    @Id
    @Column(name = "particpantid" ,nullable = false, unique = true)
    private String particpantId;

    @Column(name = "postid" ,nullable = false)
    private int postId;

    @Column(name = "userid", nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_phone", nullable = false)
    private String userPhone;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime create_at;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;






}
