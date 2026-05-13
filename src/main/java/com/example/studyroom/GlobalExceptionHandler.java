import com.example.studyroom.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler         {

@ExceptionHandler(StudentNotFoundException.class)
public ResponseEntity<String>   studentnotfound(StudentNotFoundException e) {
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(e.getMessage());
    }

//@ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<String>   wrongargument(IllegalArgumentException e)       {
//    return ResponseEntity
//            .status(HttpStatus.BAD_REQUEST)
//            .body("you sent bad data");
//}
//
//@ExceptionHandler(Exception.class)
//    public ResponseEntity<String>   exception(Exception e)      {
//    return  ResponseEntity
//                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                        .body("Something went wrong on our end");
//}

}

