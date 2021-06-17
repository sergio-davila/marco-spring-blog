package com.codeup.springblog.DAOs;

import com.codeup.springblog.models.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
}
