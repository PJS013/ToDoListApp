package com.example.demo.ToDoList;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class ToDo {
    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    private int taskNr;
    private String taskName;
    private String taskDescription;
    private LocalDate deadline;

    public ToDo() {
    }

    public ToDo(String taskName, String taskDescription, LocalDate deadline) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
    }

    public ToDo(int taskNr, String taskName, String taskDescription, LocalDate deadline) {
        this.taskNr = taskNr;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
    }

    public int getTaskNr() {
        return taskNr;
    }

    public void setTaskNr(int taskNr) {
        this.taskNr = taskNr;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "taskNr=" + taskNr +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
