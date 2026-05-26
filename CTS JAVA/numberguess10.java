import java.util.Random;
import java.util.Scanner;
public class numberguess10 {
    static Random r = new Random();
    static int n=r.nextInt(10);
public static int random(int a){
    
    if(a>n) return 1;
    else if(a==n) return 0;
    else return -1;
}
public static void inputt(){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int c = random(a);
    if(c==0){
        System.out.println("Your guess is right");
        return;
    }
    else if(c==-1){
        System.out.println("guess is too low");
    }
    else{
        System.out.println("your guess is too high");
    }
inputt();
}

    public static void main(String[] args) {
        inputt();
    }
}
