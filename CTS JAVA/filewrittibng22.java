import java.io.FileWriter;
import java.util.Scanner;

public class filewrittibng22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
       try{
        FileWriter fr = new FileWriter("Output.txt");
        fr.write(s);
        fr.close();
       }
       catch(Exception e){
        System.out.println("some error had happen");
       }
    }
}
