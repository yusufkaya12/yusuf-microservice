package com.threepounds.authservice.data.repo;

import com.threepounds.authservice.data.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  @EntityGraph(attributePaths = "authorities")
  Optional<User> findByUsername(String username);
}
