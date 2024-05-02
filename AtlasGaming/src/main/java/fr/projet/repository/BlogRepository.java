package fr.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.projet.entities.Blog;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByType(String type);
}
