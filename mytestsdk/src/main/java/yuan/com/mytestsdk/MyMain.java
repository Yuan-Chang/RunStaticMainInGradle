package yuan.com.mytestsdk;

import android.widget.Adapter;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * Created by ychang3 on 5/30/17.
 */

public class MyMain {
    public static void main(String[] args) {
        String classPath = args[0];
        String packageName = args[1];
        String fileName = args[2];
        String gsonPath = args[3];

        System.out.println(classPath);
        System.out.println(gsonPath);

        String packageFileName = packageName+"."+fileName;

        System.out.println(packageFileName);

        try {
            URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] { new File(classPath).toURI().toURL()});
            Class<?> myConfigclass = urlClassLoader.loadClass(packageFileName);
            Object instance = myConfigclass.newInstance();

            urlClassLoader = URLClassLoader.newInstance(new URL[] { new File(gsonPath).toURI().toURL()});
            Class<?> c = urlClassLoader.loadClass("com.google.gson.Gson");

            Method m = c.getMethod("toJson", Object.class);
            System.out.println(m.toString());
            //Object[] objs = new Object[]{instance};

            System.out.println(m.invoke(c.newInstance(),instance));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }  catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
