package TEAM5.roomie.Model;
import jakarta.persistence.*;
import jakarta.websocket.Encoder;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Posts")
public class Posts {

    @Id
    @Column(name = "postid" ,nullable = false, unique = true)
    private int postId;

    @Column(name = "user_name" ,nullable = false)
    private String user_name;

    @Column(name = "price" ,nullable = false)
    private int price;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public int getParticpant_count() {
        return particpant_count;
    }

    public void setParticpant_count(int particpant_count) {
        this.particpant_count = particpant_count;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String userName) {
        this.user_name = userName;
    }

    public String getUserPhone() {
        return user_phone;
    }

    public void setUserPhone(String userPhone) {
        this.user_phone = userPhone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getParticpantCount() {
        return particpant_count;
    }

    public void setParticpantCount(int particpantCount) {
        this.particpant_count = particpantCount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "user_phone" ,nullable = false)
    private String user_phone;

    @Column(name = "title" ,nullable = false)
    private String title;

    @Column(name = "content" ,nullable = false)
    private String content;

    @Column(name = "place" ,nullable = false)
    private String place;

    @Column(name = "date" ,nullable = false)
    private String date;

    @Column(name = "particpant_count" ,nullable = false)
    private int particpant_count;

    @Column(name = "max_count" ,nullable = false)
    private int max_count;

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

    @Column(name = "image")
    private String image;

    public int getMax_count() {
        return max_count;
    }

    public void setMax_count(int max_count) {
        this.max_count = max_count;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
