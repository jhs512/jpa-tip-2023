package com.example.tip;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String username;
    @Version
    private Long version;
}
