import java.lang.reflect.Method;
public class ReflectionExample {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("Student");
            Object obj = cls.getDeclaredConstructor().newInstance();
            Method[] methods = cls.getDeclaredMethods();
            System.out.println("Methods in Student class:\n");
            for(Method m : methods) {
                System.out.println("Method Name: " + m.getName());
                System.out.println("Parameter Count: " + m.getParameterCount());
                System.out.println();
            }
            Method method1 = cls.getMethod("display");
            method1.invoke(obj);
            Method method2 = cls.getMethod("showAge", int.class);
            method2.invoke(obj, 21);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}