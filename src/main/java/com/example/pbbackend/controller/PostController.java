package com.example.pbbackend.controller;

import com.example.pbbackend.model.Post;
import com.example.pbbackend.repository.PostRepository;
import com.example.pbbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;

    // edit update routes not defined yet

    @GetMapping("/posts/new")
    public void showNewPostForm() {
        // return the createPost template
    }

    @PostMapping("/posts")
    public  @ResponseBody ResponseEntity<String> createNewPost(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("date") String date, @RequestParam("tag") String tag, @RequestParam("account_id") Integer account_id) {
        Post post = new Post(title,content,date,tag,account_id);
        // add this to the database @ModelAttribute
        postRepository.save(post);
        return new ResponseEntity<String>("POST added successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public @ResponseBody ResponseEntity<String> deletePost(@PathVariable String id) {
        // delete post with this id from database
        postRepository.deleteById(Integer.parseInt(id));
        return new ResponseEntity<String>("DELETED Post successfully!", HttpStatus.OK);
    }
}
