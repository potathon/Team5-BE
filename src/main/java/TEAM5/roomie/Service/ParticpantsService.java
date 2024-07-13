package TEAM5.roomie.Service;

import TEAM5.roomie.Model.Particpants;
import TEAM5.roomie.Repository.ParticpantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticpantsService {

    @Autowired
    private ParticpantsRepository particpantsRepository;
    /* public Particpants joinGroup(int postId,String user_name,String user_phone){
        Particpants particpants = new Particpants();

    } */
}
