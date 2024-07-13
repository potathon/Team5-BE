package TEAM5.roomie.Model;

import TEAM5.roomie.Dto.UsersDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "users")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder(toBuilder = true)
public class Users extends @Valid UsersDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long post_id;

    @Column(nullable = false, length = 10)
    private String user_name;

    @Column(nullable = false, length = 20)
    private String phone;

}
