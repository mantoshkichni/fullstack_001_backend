package com.example.FullStackDemo_001.serviceIMPL;

import com.example.FullStackDemo_001.model.Post;
import com.example.FullStackDemo_001.repository.PostRepository;
import com.example.FullStackDemo_001.service.PostService;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;
    PostServiceImpl(PostRepository postRepository){
        this.postRepository=postRepository;
    }
    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }
}
