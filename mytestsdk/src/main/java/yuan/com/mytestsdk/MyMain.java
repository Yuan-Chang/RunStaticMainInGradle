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
        System.out.println("hello~MyMain2 ");

        try {
//            Class<?> c1 = Class.forName("com.google.gson.Gson");
//            System.out.println(c1.getName());


            URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] { new File(args[0]).toURI().toURL()});
            Class<?> c = urlClassLoader.loadClass("yuan.com.runstaticmainingradle.MyConfig");
            Object instance = c.newInstance();
            System.out.println("hello~MyMain2 "+instance.toString());
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
