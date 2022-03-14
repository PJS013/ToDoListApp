package com.example.demo.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    public List<ToDo> getToDo() {
        return toDoRepository.findAll();
    }

    public void addNewTask(ToDo toDo) {
        Optional<ToDo> toDoOptional = toDoRepository.findToDoByName(toDo.getTaskName());
        if(toDoOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        toDoRepository.save(toDo);
    }

    public void deleteTask(Integer taskNr) {
        boolean exists = toDoRepository.existsById(taskNr);
        if(!exists) {
            throw new IllegalStateException("task with id " + taskNr + " does not exist");
        }
        toDoRepository.deleteById(taskNr);
    }

    @Transactional
    public void updateList(Integer taskNr, String taskName, String taskDescription) {
        ToDo toDo = toDoRepository.findById(taskNr).orElseThrow(() -> new IllegalStateException(
                "task with id " + taskNr + " does not exist"
        ));
        if (taskName != null && taskName.length() > 0 && !Objects.equals(toDo.getTaskName(), taskName)) {
            toDo.setTaskName(taskName);
        }
        if (taskDescription != null && taskDescription.length() > 0 && !Objects.equals(toDo.getTaskDescription(), taskDescription)) {
            toDo.setTaskDescription(taskDescription);
        }
    }
}
