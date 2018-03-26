package com.simpletwitter.jsp.dao;

import com.simpletwitter.jsp.model.Post;

import java.util.ArrayList;

public interface PostDAO {
    ArrayList<Post> getAllPosts();
    Post getPostById(Long id);
    void savePost(Post post);
    void updatePost(Post post);
    void deletePost(Post post);
    void deletePostById(Long id);

}
