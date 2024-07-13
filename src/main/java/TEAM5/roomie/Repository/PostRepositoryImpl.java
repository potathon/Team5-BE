package TEAM5.roomie.Repository;

import TEAM5.roomie.Model.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PostRepositoryImpl implements PostRepositoryCustom {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Posts test() {
        String sql = "SELECT * FROM posts WHERE id=7";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Posts.class));
    }

    @Override
    public void updatePost(Posts post) {
        String sql = "UPDATE posts SET user_name=?, user_phone=?, title=?, content=?, meet_place=?, meet_time=?, max_count=?, user_count=?, tag=?, image=?, updated_at=? WHERE id=?";
        jdbcTemplate.update(sql, post.getUserName(), post.getUserPhone(), post.getTitle(), post.getContent(), post.getMeetPlace(), post.getMeetTime(), post.getMaxCount(), post.getUserCount(), post.getTag(), post.getImage(), post.getUpdatedAt(), post.getId());
    }


}
