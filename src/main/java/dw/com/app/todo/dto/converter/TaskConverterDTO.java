package dw.com.app.todo.dto.converter;

import dw.com.app.todo.dto.TaskDTO;
import dw.com.app.todo.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskConverterDTO {


    public TaskDTO convert(Task from) {
        return new TaskDTO(
                from.getId(),
                from.getHeader(),
                from.getDescription(),
                from.getTransactionDate(),
                from.getTaskType()
        );
    }

    public List<TaskDTO> convert(List<Task> from) {
        return from.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TaskDTO convertToDTO(Task task) {
        return  TaskDTO
                .builder()
                .transactionDate(task.getTransactionDate())
                .description(task.getDescription())
                .header(task.getHeader())
                .taskType(task.getTaskType())
                .id(task.getId())
                .build();
    }

}
