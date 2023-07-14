package com.example.tip;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUsername(String username);

    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Post> findWithShareLockById(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Post> findWithWriteLockById(Long id);
}
