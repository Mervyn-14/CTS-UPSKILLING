import java.util.Scanner;

public class Methodoverload12 {
    static int add(int a,int b){
        return a+b;
    }
    static int add(int a,int b,int c){
        return a+b+c;
    }
    static double add(double a,double b){
        return a+b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        System.out.println( add(a,b));
        System.out.println(add(a,b,b));
        System.out.println(add(c,d));
    }
}
