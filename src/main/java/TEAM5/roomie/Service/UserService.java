package TEAM5.roomie.Service;

import TEAM5.roomie.Dto.UsersDTO;
import TEAM5.roomie.Model.Users;
import TEAM5.roomie.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Users createUser(@Valid UsersDTO usersDTO, Long post_id) {
        if (isUserExists(usersDTO.getUser_name(), usersDTO.getPhone())) {
            throw new IllegalArgumentException("User already exists");
        }
        Users user = convertToEntity(usersDTO);
        user.setPost_id(post_id);
        return userRepository.save(user);
    }

    public Users updateUser(Long id, @Valid UsersDTO userDetails) {
        Users user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUser_name(userDetails.getUser_name());
            user.setPhone(userDetails.getPhone());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<Users> getUsersByPostId(Long post_id) {
        return userRepository.findByPost_id(post_id);
    }

    private Users convertToEntity(UsersDTO usersDTO) {
        Users user = new Users();
        user.setUser_name(usersDTO.getUser_name());
        user.setPhone(usersDTO.getPhone());
        return user;
    }

    private boolean isUserExists(String user_name, String phone) {
        Optional<Users> existingUser = Optional.ofNullable(userRepository.findByUser_nameAndPhone(user_name, phone));
        return existingUser.isPresent();
    }
}
