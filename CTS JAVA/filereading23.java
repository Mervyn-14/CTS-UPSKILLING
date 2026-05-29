import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class filereading23 {
    public static void main(String[] args) {
       try{
        FileReader fr = new FileReader("output.txt");
        BufferedReader br = new BufferedReader(fr);
        String L;
        while((L=br.readLine())!=null){
            System.out.println(L);
        }
       }
       catch(Exception e){
        System.out.println("Some error has happened");
       }

    }
}
