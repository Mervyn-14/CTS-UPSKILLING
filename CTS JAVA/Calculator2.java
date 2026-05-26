import java.util.Scanner;
public class Calculator2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1");
        int a = sc.nextInt();
        System.out.println("Enter num 2");
        int b = sc.nextInt();
        System.out.println("choose any one of them");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        int c = sc.nextInt();
        if(c==1){
            System.out.println(a+b);
        }
        else if(c==2){
            System.out.println(a-b);
        }
        else if(c==3){
            System.out.println(a*b);
        }
        else if(c==4){
            System.out.println(a/b);
        }
        else{
            System.out.println("invalid input");
        }
    }
}
