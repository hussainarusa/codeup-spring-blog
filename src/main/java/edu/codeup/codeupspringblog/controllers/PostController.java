package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.model.Post;
import edu.codeup.codeupspringblog.model.User;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }


//    @GetMapping("/{id}")
//    public String viewIndividualPost(@PathVariable long id, Model vModel){
//      if(postDao.existsById(id)){
//          BlogPost post = postDao.findById(id).get();
//           vModel.addAttribute("post");
//      }
//
//    }

//
//    @GetMapping("/post")
//    @ResponseBody


    @GetMapping("/create")
    public String showCreatePostView(){
        return "posts/create";
    }

    @GetMapping("/create")
    public String createPost(
            @RequestParam("title") String title,
            @RequestParam("content") String content

    ) {
        //Hard Coded User
        User hardCodedUser = userDao.findById(2L).get();
        Post newPost = new Post ( title,content, hardCodedUser);

        postDao.save(newPost);
        return "redirect:/posts";
    }
//    public List<Post> returnPosts() {
//
//       return postDao.findAll();
//    }
}


