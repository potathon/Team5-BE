package TEAM5.roomie.Repository;

import TEAM5.roomie.Model.Posts;
import TEAM5.roomie.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
