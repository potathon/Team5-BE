package TEAM5.roomie.Service;

import TEAM5.roomie.Model.Users;
import TEAM5.roomie.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users joinGroup(String user_name, String user_phone){
        Users users = new Users();
        users.setUserName(user_name);
        users.setUser_phone(user_phone);

        return userRepository.save(users);
    }
}
