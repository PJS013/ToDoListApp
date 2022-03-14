package com.example.demo.ToDoList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

    @Query("SELECT s FROM ToDo s WHERE s.taskName=?1")
    Optional<ToDo> findToDoByName(String taskName);
}
