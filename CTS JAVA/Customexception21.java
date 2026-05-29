import java.util.Scanner;
class InvalidAgeException extends Exception{
    InvalidAgeException(String m){
        super(m);
    }
}

public class Customexception21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        try{
            if(n<18){
                throw new InvalidAgeException("Age must be greater than 18");
            }
        }
            catch(InvalidAgeException e){
                System.out.println(e.getMessage());
            }
        }
    }

