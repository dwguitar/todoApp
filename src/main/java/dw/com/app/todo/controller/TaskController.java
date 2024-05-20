package dw.com.app.todo.controller;

import dw.com.app.todo.dto.CreateTaskRequestDTO;
import dw.com.app.todo.dto.TaskDTO;
import dw.com.app.todo.dto.UpdateTaskRequestDTO;
import dw.com.app.todo.service.TaskService;
import dw.com.app.todo.shared.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> getTaskById()
    {
        return ResponseEntity.ok(taskService.findTaskAll());
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDTO> getTaskById(
            @PathVariable Long id)
    {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping("/task")
    public ResponseEntity<TaskDTO> createTask(
            @Valid @RequestBody CreateTaskRequestDTO requestDto)
    {
        return ResponseEntity.ok(taskService.createTask(requestDto));
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskDTO> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTaskRequestDTO requestDto)
    {
        return ResponseEntity.ok(taskService.updateTask(id, requestDto));
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        GenericResponse response = new GenericResponse("task deleted");
        return ResponseEntity.ok(response);
    }
}
