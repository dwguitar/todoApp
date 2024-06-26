package dw.com.app.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException {
    private final String message;
    public TaskNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
