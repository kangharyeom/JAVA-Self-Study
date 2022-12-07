package Java;

public class Lambda {
    public static void main(String[] args) {

        ExampleFuction emp = (num1, num2) -> num1 + num2;
        System.out.println(emp.sum(1,2));
    }

    interface ExampleFuction {
        public abstract int sum(int a, int b);
    }
}
