class Animal {
void makeSound(){
    System.out.println("ill make sound");
}
}
class Dog extends Animal{
@Override  
void makeSound(){
    System.out.println("Bark");
}
}
public class Inheritance18 {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.makeSound();
        Dog d = new Dog();
        d.makeSound();
    }
}
