package exception;

public class AgeNotFound extends RuntimeException{
    public AgeNotFound(String InvalidAge){
        super(InvalidAge);
    }
}

