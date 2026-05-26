import java.util.Scanner;

public class Factorial11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter non negative number");
        int a = sc.nextInt();
        for(int i=a-1;i>=1;i--){
            a*=i;
        }
        System.out.println(a);
    }
}
