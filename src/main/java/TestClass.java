/**
 * Created by amit.bhengra on 01/03/17.
 */
public class TestClass {

    private static int i;
    private  int b;

    static class Test1{
      static int j = i;
    }

    class Test2{
        int a = Test1.j;
        int c = b;

    }
}
