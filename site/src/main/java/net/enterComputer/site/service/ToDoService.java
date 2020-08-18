package net.enterComputer.site.service;

import net.enterComputer.site.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllToDos();

    void saveToDo(ToDo toDo);

    ToDo getToDoById(long id);

    void deleteToDoById(long id);

}
