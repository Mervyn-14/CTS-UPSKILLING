import java.util.Scanner;

public class Stringrev15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // StringBuilder s1 = new StringBuilder(s);
        // System.out.println(s1.reverse());
        char[] ch = s.toCharArray();
        StringBuilder s1 = new StringBuilder();
        for(int i=ch.length-1;i>=0;i--){
            s1.append(ch[i]);
        }
        System.out.println(s1);
    }
}
