package desafio.luizalab.infrastructure.exception;

import desafio.luizalab.core.exception.CustomerIdDuplicate;
import desafio.luizalab.core.exception.WishlistEmptyException;
import desafio.luizalab.core.exception.WishlistFullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionGlobalHandler {

    @ExceptionHandler(CustomerIdDuplicate.class)
    public ResponseEntity handleDuplicate(CustomerIdDuplicate e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MessageError(e.getMessage()));
    }

    @ExceptionHandler(WishlistFullException.class)
    public ResponseEntity handleFullList(WishlistFullException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MessageError(e.getMessage()));
    }

    @ExceptionHandler(WishlistEmptyException.class)
    public ResponseEntity handleEmptyList(WishlistEmptyException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MessageError(e.getMessage()));
    }
}
