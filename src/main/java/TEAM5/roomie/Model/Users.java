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

    @Column(name = "user_name" ,nullable = false)
    private String userName;

    @Column(name = "userid" ,nullable = false)
    private String user_phone;


}
