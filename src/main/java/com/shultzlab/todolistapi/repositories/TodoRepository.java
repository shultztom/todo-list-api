package com.shultzlab.todolistapi.repositories;

import com.shultzlab.todolistapi.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByOwner(String owner);
}
