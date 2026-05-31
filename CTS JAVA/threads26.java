import java.io.InterruptedIOException;

class M extends Thread {
   public  void run(){
    for(int i=0;i<50;i++){
        System.out.println("thread 1");
    }
}
}

class J implements Runnable{

     public void run() {
        for(int i=0;i<50;i++){
            System.out.println("thread 2");
            // try { Thread.sleep(2);}
            // catch(InterruptedException e){
            // }
        }
     }
}



public class threads26 {
    public static void main(String[] args) {
        M m = new M();
        m.start();
        m.setPriority(2);
        J j = new J();
        Thread t = new Thread(j);
        t.start();

    }
}
