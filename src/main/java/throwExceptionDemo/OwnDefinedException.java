package throwExceptionDemo;

public class OwnDefinedException extends RuntimeException {

  public OwnDefinedException(String s) {
    super(s);
  }
}
