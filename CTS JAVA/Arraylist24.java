import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist24 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();
        for(int i=1;i<=n;i++){
            list.add(sc.nextLine());
        }
        System.out.println();
        System.out.println("answers are");
        for(String s : list){
            System.out.println(s);
        }
    }
}
