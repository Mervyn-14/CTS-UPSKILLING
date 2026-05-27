public class Car17 {
    String make = "platinum";
    String model = "B3";
    int year = 2020;
    static void Displaydetails(){
        Car17 c = new Car17();
        System.out.println(c.make);
        System.out.println(c.model);
        System.out.println(c.year);
    }
    public static void main(String[] args) {
        Displaydetails();
    }
}