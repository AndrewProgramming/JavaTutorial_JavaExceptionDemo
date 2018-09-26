package throwExceptionDemo;

public class ThrowExceptionDemo {

  public static void main(String[] args) {
    try {
      // Throw an object of user defined exception
      throw new OwnDefinedException("OwnDefinedException occurs");
    } catch (OwnDefinedException ex) {
      // Print the message from OwnDefinedException object
      System.out.println(ex.getMessage());
    }
  }

}
