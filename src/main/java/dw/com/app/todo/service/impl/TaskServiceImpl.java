package dw.com.app.todo.service.impl;

import dw.com.app.todo.dto.CreateTaskRequestDTO;
import dw.com.app.todo.dto.TaskDTO;
import dw.com.app.todo.dto.UpdateTaskRequestDTO;
import dw.com.app.todo.dto.converter.TaskConverterDTO;
import dw.com.app.todo.exception.TaskNotFoundException;
import dw.com.app.todo.model.Task;
import dw.com.app.todo.model.TaskType;
import dw.com.app.todo.repository.TaskRepository;
import dw.com.app.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskConverterDTO converter;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskConverterDTO converter) {
        this.taskRepository = taskRepository;
        this.converter = converter;
    }

    @Override
    public List<TaskDTO> findTaskAll() {
        return converter.convert(taskRepository.findAll());
    }

    @Override
    public Task findTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task could not find by id: " + id));
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        return converter.convert(taskRepository.getReferenceById(id));
    }

    @Override
    public TaskDTO createTask(CreateTaskRequestDTO requestDto) {
        Task task = Task.builder()
                .header(requestDto.getTaskHeader())
                .description(requestDto.getTaskDescription())
                .transactionDate(LocalDateTime.now())
                .taskType(TaskType.TODO)
                .build();


        return converter.convert(taskRepository.save(task));
    }

    @Override
    public TaskDTO updateTask(Long id, UpdateTaskRequestDTO requestDto) {
        Task taskDb = taskRepository.findById(id).orElse(null);
        if(taskDb !=  null) {
            taskDb.setTaskType(requestDto.getTaskType());
            taskDb.setDescription(requestDto.getTaskDescription());
            taskDb.setHeader(requestDto.getTaskHeader());
            taskDb.setTransactionDate(LocalDateTime.now());
            return converter.convert(taskRepository.save(taskDb));
        }
        return new TaskDTO();
    }

    @Override
    public void deleteTask(Long id) {
        final Task task = findTaskById(id);
        taskRepository.deleteById(task.getId());
    }
}
