package yuan.com.mytestsdk;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by ychang3 on 5/30/17.
 */

public class MyMain {
    public static void main(String[] args) {
        String classPath = args[0];
        String packageName = args[1];
        String fileName = args[2];

        System.out.println(classPath);

        String packageFileName = packageName+"."+fileName;

        System.out.println(packageFileName);

        try {
            URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] { new File(classPath).toURI().toURL()});
            Class<?> c = urlClassLoader.loadClass(packageFileName);
            Object instance = c.newInstance();

            System.out.println(instance.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
