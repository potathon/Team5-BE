package TEAM5.roomie.Repository;

import TEAM5.roomie.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUser_nameAndPhone(String user_name, String phone);
    List<Users> findByPost_id(Long post_id);
}
