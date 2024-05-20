package dw.com.app.todo.shared;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse {
    private String message;

    public GenericResponse(String message) {
        this.message = message;
    }
}