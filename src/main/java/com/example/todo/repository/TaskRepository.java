package com.example.todo.repository;

import com.example.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    long deleteByLocalTaskIdAndUsername(Long id, String username);
    List<Task> findByUsername(String username);
}
