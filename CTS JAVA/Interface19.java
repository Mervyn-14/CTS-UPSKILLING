interface Playable {
void play();
}
class Guitar implements Playable{
    public void play(){
    System.out.println("ill play guitar");
 }
}
class Piano implements Playable {
    public void play() {
        System.out.println("ill play piano");
    }
}

public class Interface19 {
    public static void main(String[] args) {
        Guitar g = new Guitar();
        g.play();
        Piano p = new Piano();
        p.play();
    }
}
