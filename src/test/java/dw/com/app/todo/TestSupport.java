package dw.com.app.todo;

import dw.com.app.todo.dto.CreateTaskRequestDTO;
import dw.com.app.todo.model.Task;
import dw.com.app.todo.model.TaskType;

import java.time.LocalDateTime;

public class TestSupport {

    public Task generateTask(Long id, String header, String description) {
        return new Task(
                100L,
                "taskHeader",
                "taskDescription",
                LocalDateTime.now(),
                TaskType.TODO);
    }

    public CreateTaskRequestDTO generateRequestDto() {
        return new CreateTaskRequestDTO(
                "taskHeader",
                "taskDescription",
                LocalDateTime.now());
    }
}
