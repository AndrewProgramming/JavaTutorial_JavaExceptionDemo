> Find more tutorials on [Andrew Programming](http://www.andrew-programming.com)

# Putting It All Together

The previous sections described how to construct the `try`, `catch`, and `finally` code blocks for the `writeList` method in the `ListOfNumbers` class. Now, let's walk through the code and investigate what can happen.

When all the components are put together, the `writeList` method looks like the following.

```java
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
```

As mentioned previously, this method's `try` block has three different exit possibilities; here are two of them.

1. Code in the `try` statement fails and throws an exception. This could be an `IOException` caused by the `new FileWriter` statement or an `IndexOutOfBoundsException` caused by a wrong index value in the `for` loop.
2. Everything succeeds and the `try` statement exits normally.

Let's look at what happens in the `writeList` method during these two exit possibilities.

## Scenario 1: An Exception Occurs

The code below will cause an `IndexOutOfBoundException` since i==4 is not leagal.

But since we define `final` block so this program will execute `final` block first then catch the error.

```java
Entering try statement
Closing PrintWriter
Caught IndexOutOfBoundsException: 4 
```

The boldface code in the following listing shows the statements that get executed during this scenario:

```java
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
```

## Scenario 2: The try Block Exits Normally

In this scenario, all the statements within the scope of the `try` block execute successfully and throw no exceptions. Execution falls off the end of the `try` block, and the runtime system passes control to the `finally` block. Because everything was successful, the `PrintWriter` is open when control reaches the `finally` block, which closes the `PrintWriter`. Again, after the `finally` block finishes executing, the program continues with the first statement after the `finally` block.

Here is the output from the `ListOfNumbers` program when no exceptions are thrown.

```java
Entering try statement
Closing PrintWriter
```

The boldface code in the following sample shows the statements that get executed during this scenario.

```java
public void writeList() {
    PrintWriter out = null;

    int list[] = {1, 2, 3, 4};

    try {
      System.out.println("Entering" + " try statement");

      out = new PrintWriter(new FileWriter("OutFile.txt"));
      for (int i = 0; i < list.length; i++) {
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
```

## Source code

[Github](https://github.com/AndrewProgramming/JavaTutorial_JavaExceptionDemo/tree/master)
