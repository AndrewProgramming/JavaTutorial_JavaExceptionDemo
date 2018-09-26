package tryCatchDemo;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TryCatchFinallyDemo {

  public static void main(String[] args) {
    TryCatchFinallyDemo tryCatchDemo = new TryCatchFinallyDemo();
    tryCatchDemo.writeList();

  }

  public void writeList() {
    PrintWriter out = null;

    int list[] = {1, 2, 3, 4};

    try {
      System.out.println("Entering" + " try statement");

      out = new PrintWriter(new FileWriter("OutFile.txt"));
      //Will case an IndexOutOfBoundsException exception
      for (int i = 0; i <= list.length; i++) {
        out.println("Value at: " + i + " = " + list[i]);
      }
    } catch (IndexOutOfBoundsException e) {
      System.err.println("Caught IndexOutOfBoundsException: "
          + e.getMessage());

    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());

    } finally {
      if (out != null) {
        System.out.println("Closing PrintWriter");
        out.close();
      } else {
        System.out.println("PrintWriter not open");
      }
    }
  }

}
