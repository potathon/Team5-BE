package TEAM5.roomie.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "Particpants")
public class Particpants{
    public String getParticpantId() {
        return particpantId;
    }

    public void setParticpantId(String particpantId) {
        this.particpantId = particpantId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

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
