import java.util.Scanner;

public class Trycatch20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        try{
            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            System.out.println(e);
            System.out.println("Arthimentic exception happened");
        }
    }
}
