import com.sun.javafx.util.Logging;

import java.net.URL;
import java.util.ArrayList;

public class FunnyClassLoader {
    public static void main(String[] args) {
        System.out.println("ClassLoader of ArrayList:" + ArrayList.class.getClassLoader());
        System.out.println("ClassLoader of FunnyClassLoader:" + FunnyClassLoader.class.getClassLoader());
        System.out.println("ClassLoader of Logging:" + Logging.class.getClassLoader());

        URL[] url=sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL u : url){
            System.out.println(u.toExternalForm());
        }
    }
}
