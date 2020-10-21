import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        XClass obj = new XClass();
        Class<?> helloClass = obj.findClass("Hello");
        Method hello = helloClass.getMethod("hello");
        Object i = helloClass.newInstance();
        hello.invoke(i);
    }
}
