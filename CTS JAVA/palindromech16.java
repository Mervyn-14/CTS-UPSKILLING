import java.util.Scanner;

public class palindromech {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuffer s1 = new StringBuffer();
        // here iam using this to remove non alpha numeric characters
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))) s1.append(s.charAt(i));
        }
        if(s1.toString().equals(s1.reverse().toString())){
            System.out.println("its palidrome");
        }
        else{
            System.out.println("not palidrome");
        }

    }
}
