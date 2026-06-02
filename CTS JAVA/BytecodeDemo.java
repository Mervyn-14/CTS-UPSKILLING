public class BytecodeDemo {
    public void display() {
        int a = 10;
        int b = 20;
        int sum = a + b;

        System.out.println("Sum = " + sum);
    }
    public static void main(String[] args) {
        BytecodeDemo obj = new BytecodeDemo();
        obj.display();
    }
}