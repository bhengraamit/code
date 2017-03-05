/**
 * Created by amit.bhengra on 01/03/17.
 */
public class TestInner {

    public static void main(String[] args) {
        TestClass test = new TestClass();
        TestClass.Test2 testClass = test.new Test2();
    }
}
