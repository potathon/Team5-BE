package TEAM5.roomie.Service;

import TEAM5.roomie.Dto.UserDTO;
import TEAM5.roomie.Model.Users;
import TEAM5.roomie.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Users createUser(@Valid UserDTO userDTO) {
        Users user = convertToEntity(userDTO);
        return userRepository.save(user);
    }

    public Users updateUser(Long id, @Valid UserDTO userDetails) {
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

    private Users convertToEntity(UserDTO userDTO) {
        Users user = new Users();
        user.setUser_name(userDTO.getUser_name());
        user.setPhone(userDTO.getPhone());
        return user;
    }

}
