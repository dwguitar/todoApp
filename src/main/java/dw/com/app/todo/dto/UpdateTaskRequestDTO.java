package dw.com.app.todo.dto;

import dw.com.app.todo.model.TaskType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateTaskRequestDTO {

    @NotBlank(message = "task header can not be blank!")
    private String taskHeader;
    private String taskDescription;
    private TaskType taskType;
}
