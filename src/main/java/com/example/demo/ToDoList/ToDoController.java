package com.example.demo.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/todo")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getToDo() {
        return toDoService.getToDo();
    }

    @PostMapping
    public void registerNewTask(@RequestBody ToDo toDo) {
        toDoService.addNewTask(toDo);
    }

    @DeleteMapping(path = "{taskNr}")
    public void deleteTask(@PathVariable("taskNr") Integer taskNr) {toDoService.deleteTask(taskNr);}

    @PutMapping(path = "{taskNr}")
    public void updateTasks(
            @PathVariable("taskNr") Integer taskNr,
            @RequestParam(required = false) String taskName,
            @RequestParam(required = false) String taskDescription
    ) {
        toDoService.updateList(taskNr, taskName, taskDescription);
    }
}
