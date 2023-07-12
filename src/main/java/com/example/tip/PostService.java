package com.example.tip;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findByUsername(String username) {
        return postRepository.findByUsername(username);
    }

    @SneakyThrows
    public Optional<Post> findWithShareLockById(Long id) {

        postRepository.findWithShareLockById(id);

        Thread.sleep(10000);

        return postRepository.findWithShareLockById(id);
    }
}