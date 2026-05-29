import java.util.HashMap;
import java.util.Scanner;

public class Hashmap25 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer,String> map = new HashMap<>();
    System.out.println("howmmany inp");
    int n = sc.nextInt();
    for(int i=1;i<=n;i++){
        System.out.println("enter id");
        int n1=sc.nextInt();
         sc.nextLine();
        System.out.println("enter name");
        String s1 = sc.nextLine();
        map.put(n1, s1);
    }
    System.out.println("enter id to search");
    int a=sc.nextInt();
    if(map.get(a)!=null){
        System.out.println(map.get(a));
    }
    else{
        System.out.println("id not found");
    }
}
} Exception
