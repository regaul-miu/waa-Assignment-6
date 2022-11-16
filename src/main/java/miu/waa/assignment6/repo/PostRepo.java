package miu.waa.assignment6.repo;

import miu.waa.assignment6.domain.Comment;
import miu.waa.assignment6.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    Post findById(long id);
    @Query(value = "select p.comments from Post p where p.id =:id")
    List<Comment> findComments(long id);


    List<Post> findByTitleLike(String title);
}
