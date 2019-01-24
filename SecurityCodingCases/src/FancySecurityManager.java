
import java.io.FilePermission;
import java.security.AccessControlContext;
import java.security.AccessController;

public class FancySecurityManager extends SecurityManager {

    public static void main(String[] args) {

        // get current security context
        AccessControlContext con = AccessController.getContext();

        // set the policy file as the system securuty policy
        System.setProperty("java.security.policy", "resource/java.policy");

        // create a security manager
        FancySecurityManager sm = new FancySecurityManager();

        // set the system security manager
        System.setSecurityManager(sm);

        // perform the check
        //sm.checkPermission(new FilePermission("test.txt", "read,write"), con);

        // print a message if we passed the check
        //System.out.println("Allowed!");


        System.out.println(System.getProperty("java.version"));
        System.setProperty("java.version","1.7");
        System.out.println(System.getProperty("java.version"));

    }
}