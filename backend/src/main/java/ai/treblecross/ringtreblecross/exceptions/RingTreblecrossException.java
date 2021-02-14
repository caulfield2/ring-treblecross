package ai.treblecross.ringtreblecross.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RingTreblecrossException extends Exception {
    public RingTreblecrossException(String message) {
        super(message);
    }
}
