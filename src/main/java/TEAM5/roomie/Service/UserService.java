package TEAM5.roomie.Service;

import TEAM5.roomie.Dto.UsersDTO;
import TEAM5.roomie.Model.Posts;
import TEAM5.roomie.Model.Users;
import TEAM5.roomie.Repository.PostRepository;
import TEAM5.roomie.Repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private final PostRepository postRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public Users createUser(@Valid UsersDTO usersDTO, Long post_id) {
        if (isUserExists(usersDTO.getUser_name(), usersDTO.getPhone())) {
            throw new IllegalArgumentException("User already exists");
        }

        Posts post = postRepository.findById(Math.toIntExact(post_id)).orElseThrow(() -> new IllegalArgumentException("Post not found"));

        Users user = convertToEntity(usersDTO);
        user.setPostId(post.getId());

        post.setUser_count(post.getUser_count() + 1);
        postRepository.save(post);

        return userRepository.save(user);
    }

    public Users updateUser(Long id, @Valid UsersDTO userDetails) {
        Users user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUserName(userDetails.getUser_name());
            user.setPhone(userDetails.getPhone());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<Users> getUsersByPostId(Long postId) {
        return userRepository.findByPostId(postId);
    }

    private Users convertToEntity(UsersDTO usersDTO) {
        Users user = new Users();
        user.setUserName(usersDTO.getUser_name());
        user.setPhone(usersDTO.getPhone());
        return user;
    }

    private boolean isUserExists(String userName, String phone) {
        Optional<Users> existingUser = Optional.ofNullable(userRepository.findByUserNameAndPhone(userName, phone));
        return existingUser.isPresent();
    }
}
