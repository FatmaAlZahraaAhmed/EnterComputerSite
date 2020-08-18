package net.enterComputer.site.service;

import net.enterComputer.site.model.ToDo;
import net.enterComputer.site.repositroy.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDOServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    //getAllToDos and return it as a list of model ToDo
    @Override
    public List<ToDo> getAllToDos() {

        //get them by the repository
        return toDoRepository.findAll();
    }


    //pass the object model to the method and save it
    @Override
    public void saveToDo(ToDo toDo) {
        this.toDoRepository.save(toDo);
    }

    @Override
    public ToDo getToDoById(long id) {
		/*Optional is a container object which may or may not
	    contain a non-null value.
	    You must import java.util package to use this class.
	    If a value is present, isPresent() will return true
	    and get() will return the value
	    */
        Optional<ToDo> optional = toDoRepository.findById(id);
        ToDo todo = null;
        if (optional.isPresent()) {
            todo = optional.get();
        } else {
            throw new RuntimeException("Todo not found for id ::" + id);
        }
        return todo;//return the model object
    }

    @Override
    public void deleteToDoById(long id) {
        this.toDoRepository.deleteById(id);

    }

}
