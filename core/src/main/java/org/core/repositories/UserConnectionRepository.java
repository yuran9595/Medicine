package org.core.repositories;

import org.core.model.UserConnection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserConnectionRepository extends JpaRepository<UserConnection, Long> {
    List<UserConnection> findAllByUserId(Long userId);
}
