package IoC.exceptions;

public class LocationExceptionCustom extends RuntimeException {

   public LocationExceptionCustom(String messege){
       super(messege);
   }

   public LocationExceptionCustom(String message, Throwable cause){
       super(message, cause);
   }
}
