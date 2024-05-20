package dw.com.app.todo.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTaskRequestDTO {

    @NotBlank(message = "task header can not be blank!")
    private String taskHeader;
    private String taskDescription;
    private LocalDateTime transactionDate;
}
