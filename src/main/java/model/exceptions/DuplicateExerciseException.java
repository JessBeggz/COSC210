package model.exceptions;

public class DuplicateExerciseException extends Exception{

    public DuplicateExerciseException() {

    }

    public DuplicateExerciseException(String msg) {
        super(msg);
    }
}
