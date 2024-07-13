package TEAM5.roomie.Repository;

import TEAM5.roomie.Model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Integer>, PostRepositoryCustom {

    List<Posts> findByTag(String groupBuyPosts);
}
