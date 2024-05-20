package dw.com.app.todo.dto;

import dw.com.app.todo.model.TaskType;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TaskDTO {

    private Long id;
    private String header;
    private String description;
    private LocalDateTime transactionDate;
    private TaskType taskType;
}
