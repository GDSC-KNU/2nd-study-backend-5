package GDSCBackend5.HappyNewYear.server.service;

import GDSCBackend5.HappyNewYear.server.domain.Post;
import GDSCBackend5.HappyNewYear.server.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Long write(Post post){
        postRepository.save(post);

        return post.getPostid();
    }
}