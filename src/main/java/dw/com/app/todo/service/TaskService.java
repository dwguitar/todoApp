package dw.com.app.todo.service;

import dw.com.app.todo.dto.CreateTaskRequestDTO;
import dw.com.app.todo.dto.TaskDTO;
import dw.com.app.todo.dto.UpdateTaskRequestDTO;
import dw.com.app.todo.model.Task;

import java.util.List;


public interface TaskService {

     List<TaskDTO> findTaskAll();

     Task findTaskById(Long id);

     TaskDTO getTaskById(Long id);

     TaskDTO createTask(CreateTaskRequestDTO requestDto);

     TaskDTO updateTask(Long id, UpdateTaskRequestDTO requestDto);

     void deleteTask(Long id);
}
