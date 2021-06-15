package com.codeup.springblog.DAOs;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title); // select * from ads where title = ?
    Post findByTitleLike(String searchPattern); // select * from ads where title LIKE = ?
    Post findFirstByTitle(String title); // select * from ads where title = ? limit 1
}
