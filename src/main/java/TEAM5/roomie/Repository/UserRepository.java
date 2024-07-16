package TEAM5.roomie.Repository;

import TEAM5.roomie.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserNameAndPhone(String userName, String phone);
    List<Users> findByPostId(Long postId);
    Optional<Users> findByUserNameAndPhoneAndPostId(String userName, String phone, Long postId);
}
