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

    @Autowired
    private final PostRepository postRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public Users createUser(@Valid UsersDTO usersDTO, Long postId) {
        if (isUserExists(usersDTO.getUser_name(), usersDTO.getPhone(), postId)) {
            throw new IllegalArgumentException("User already exists");
        }

        Posts post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));

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

    private boolean isUserExists(String userName, String phone, Long postId) {
        Optional<Optional<Users>> existingUser = Optional.ofNullable(userRepository.findByUserNameAndPhoneAndPostId(userName, phone, postId));
        return existingUser.isPresent();
    }



    public void deletePost(Long id) {
        postRepository.deleteById(id);  // Long 타입의 id를 사용
    }

    @Transactional
    public void cancelParticipation(Long postId, String userName, String phone) {
        Optional<Users> userOptional = userRepository.findByUserNameAndPhoneAndPostId(userName, phone, postId);

        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            userRepository.delete(user);

            Posts post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
            post.setUser_count(post.getUser_count() - 1);
            postRepository.save(post);
        } else {
            throw new IllegalArgumentException("User not found in the post");
        }
    }
}

