package dw.com.app.todo.service;

import dw.com.app.todo.TestSupport;
import dw.com.app.todo.dto.CreateTaskRequestDTO;
import dw.com.app.todo.dto.TaskDTO;
import dw.com.app.todo.dto.converter.TaskConverterDTO;
import dw.com.app.todo.exception.TaskNotFoundException;
import dw.com.app.todo.model.Task;
import dw.com.app.todo.model.TaskType;
import dw.com.app.todo.repository.TaskRepository;
import dw.com.app.todo.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class TaskServiceTest extends TestSupport {

    private TaskRepository taskRepository;

    private TaskConverterDTO converter;

    private TaskService taskService;

    @BeforeEach
    public void setup() {
        taskRepository = mock(TaskRepository.class);
        converter = mock(TaskConverterDTO.class);

        taskService = new TaskServiceImpl(taskRepository, converter);
    }

    @Test
    public void testFindByTaskId_whenTaskIdExists_shouldReturnTask() {
        Task task = generateTask(1000L, "header", "description");

        Mockito.when(taskRepository.findById(task.getId()))
                .thenReturn(Optional.of(task));

        Task result = taskService.findTaskById(task.getId());

        assertEquals(result, task);
    }

    @Test
    public void testFindByTaskId_whenTaskIdDoesNotExists_shouldThrowTaskNotFoundException() {
        Mockito.when(taskRepository.findById(0L))
                .thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class,
                () -> taskService.findTaskById(0L));
    }

    @Test
    public void testCreateTask_whenIdExist_shouldCreateTask() {
        CreateTaskRequestDTO requestDto = generateRequestDto();
        Task task = generateTask(1000L,"taskHeader", "taskDescription");
        TaskDTO expected = new TaskDTO(
                1000L,
                "taskHeader",
                "taskDescription",
                LocalDateTime.now(),
                TaskType.TODO);

        Mockito.when(taskRepository.save(task)).thenReturn(task);
        Mockito.when(converter.convert(task)).thenReturn(expected);

        TaskDTO result = taskService.createTask(requestDto);

    }

}
