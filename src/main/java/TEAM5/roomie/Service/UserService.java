package TEAM5.roomie.Service;

import TEAM5.roomie.Dto.UsersDTO;
import TEAM5.roomie.Model.Users;
import TEAM5.roomie.Repository.UserRepository;
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

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Users createUser(@Valid UsersDTO usersDTO, Long postId) {
        if (isUserExists(usersDTO.getUserName(), usersDTO.getPhone())) {
            throw new IllegalArgumentException("User already exists");
        }
        Users user = convertToEntity(usersDTO);
        user.setPostId(postId);
        return userRepository.save(user);
    }

    public Users updateUser(Long id, @Valid UsersDTO userDetails) {
        Users user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUserName(userDetails.getUserName());
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
        user.setUserName(usersDTO.getUserName());
        user.setPhone(usersDTO.getPhone());
        return user;
    }

    private boolean isUserExists(String userName, String phone) {
        Optional<Users> existingUser = Optional.ofNullable(userRepository.findByUserNameAndPhone(userName, phone));
        return existingUser.isPresent();
    }
}
