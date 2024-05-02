package fr.projet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fr.projet.entities.Blog;
import fr.projet.repository.BlogRepository;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping
    public Blog createBlog(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("image") String image,
            @RequestParam("type") String type) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setImage(image);
        blog.setType(type);
        blog.setCreatedAt(new Date());
        return blogRepository.save(blog);
    }
    
    @GetMapping("/allBlog")
    public Iterable<Blog> getAllBlog(){
        return blogRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Blog getGameById(@PathVariable Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id " + id));
    }
    
    @GetMapping("/byType/{type}")
    public List<Blog> getBlogsByType(@PathVariable String type) {
        return blogRepository.findByType(type);
    }

    
}
