package edu.codeup.entspringblog.controllers;

import edu.codeup.codeupspringblog.repositories.PostRepository;
import edu.codeup.entspringblog.models.BlogPost;
import edu.codeup.entspringblog.models.User;
import edu.codeup.entspringblog.repositories.BlogPostRepository;
import edu.codeup.entspringblog.repositories.UserRepository;
import edu.codeup.entspringblog.services.EmailSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class BlogPostController<UserRepository> {

    private final PostRepository blogPostDao;
    private PostRepository PostDao;
    private UserRepository userDao;
    private EmailSvc emailSvc;

    public BlogPostController(PostRepository blogPostDao, UserRepository userDao, EmailSvc emailSvc) {
        this.blogPostDao = blogPostDao;
        this.userDao = userDao;
        this.emailSvc = emailSvc;
    }

    @GetMapping
    public String indexPage(Model vModel) {
        vModel.addAttribute("blogposts", blogPostDao.findAll());
        return "blogposts/index";
    }

    @GetMapping("/{id}")
    public String viewIndividualPost(@PathVariable long id, Model vModel) {
        if(blogPostDao.existsById(id)) {
            BlogPost post = blogPostDao.findById(id).get();
            vModel.addAttribute("blogpost", post);
            return "blogposts/show";
        }
        return "redirect:/posts";
    }

    @GetMapping("/create")
    public String showCreatePostView(Model model) {
        model.addAttribute("post", new BlogPost());
        return "blogposts/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute BlogPost post) {
        // Hard Coded user SaintSteve
        User hardCodedUser = userDao.findById(1L).get();
        BlogPost postToCreate = new BlogPost(
                post.getTitle(),
                post.getBody(),
                hardCodedUser
        );
        blogPostDao.save(postToCreate);
        emailSvc.prepareAndSend(postToCreate, "New Post", "You have created a new post!");
        return "redirect:/posts";
    }
    @GetMapping("/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        BlogPost postToEdit = blogPostDao.findById(id).get();
        model.addAttribute("post");
        return "blogposts/edit";
    }

    @PostMapping("/{id}/edit")
    public String insertEdit(@ModelAttribute BlogPost post, @PathVariable long id){
        BlogPost postToEdit = blogPostDao.findById(id).get();
        postToEdit.setTitle(post.getTitle());
        postToEdit.setBody(post.getBody());
        blogPostDao.save(postToEdit);
        return "redirect:/posts/"+id;
    }
}
