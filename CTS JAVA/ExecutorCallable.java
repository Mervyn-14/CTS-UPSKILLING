import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class ExecutorCallable {
    public static void main(String[] args) {
        try {
            ExecutorService executor =
                    Executors.newFixedThreadPool(3);
            Callable<Integer> task1 = () -> {
                int sum = 10 + 20;
                return sum;
            };
            Callable<Integer> task2 = () -> {
                int product = 5 * 6;
                return product;
            };
            Callable<String> task3 = () -> {
                return "Welcome Ron!";
            };
            Future<Integer> result1 =
                    executor.submit(task1);

            Future<Integer> result2 =
                    executor.submit(task2);

            Future<String> result3 =
                    executor.submit(task3);
            System.out.println(
                    "Sum Result: " + result1.get());
            System.out.println(
                    "Product Result: " + result2.get());
            System.out.println(
                    "Message: " + result3.get());
            executor.shutdown();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}