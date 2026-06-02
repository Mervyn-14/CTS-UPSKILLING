public class VirtualThreadExample {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        for(int i = 1; i <= 10; i++) {
            int threadNumber = i;
            Thread.startVirtualThread(() -> {

                System.out.println(
                    "Virtual Thread " +
                    threadNumber +
                    " running"
                );

            });
        }
        Thread.sleep(2000);
        long endTime = System.currentTimeMillis();
        System.out.println(
            "\nExecution Time: " +
            (endTime - startTime) +
            " ms"
        );
    }
}