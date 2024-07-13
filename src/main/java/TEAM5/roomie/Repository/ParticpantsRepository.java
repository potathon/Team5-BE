package TEAM5.roomie.Repository;

import TEAM5.roomie.Model.Particpants;
import TEAM5.roomie.Model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticpantsRepository  extends JpaRepository<Particpants, Integer> {
}
