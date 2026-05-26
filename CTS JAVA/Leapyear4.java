import java.util.Scanner;

public class Leapyear4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        if(a%400==0){
            System.out.println("leapyear");
        }
        else if(a%100==0){
            System.out.println("not leap");
        }
        else if(a%4==0){
            System.out.println("leapyear");
        }
        else{
            System.out.println("not leap");
        }
    }
}
