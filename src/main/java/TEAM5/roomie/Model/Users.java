package TEAM5.roomie.Model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder(toBuilder = true)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String user_name;

    @Column(nullable = false, length = 20)
    private String phone;

}
