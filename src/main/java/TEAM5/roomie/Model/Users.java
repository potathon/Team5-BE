package TEAM5.roomie.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Posts")
public class Users {

    @Id
    @Column(name = "userid" ,nullable = false, unique = true)
    private String userId;

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

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    @Column(name = "user_name" ,nullable = false)
    private String userName;

    @Column(name = "userid" ,nullable = false)
    private String user_phone;


}
