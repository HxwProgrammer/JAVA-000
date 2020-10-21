import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * 自定义的ClassLoader
 */
public class XClass extends ClassLoader {
    @Override
    public Class<?> findClass(String name) {
        String filePath = XClass.class.getResource("Hello.xlass").toString();
        filePath = filePath.replace("file:/", "");
        System.out.println("f: " + filePath);

        File file = new File(filePath);
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            int len = is.available();

            byte[] b = new byte[len];
            is.read(b, 0, len);

            for (int i = 0; i < b.length; ++i) {
                b[i] = (byte) (255 - b[i]);
            }
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
