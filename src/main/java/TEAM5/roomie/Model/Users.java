package TEAM5.roomie.Model;

import TEAM5.roomie.Dto.UsersDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users extends @Valid UsersDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "phone")
    private String phone;


}
