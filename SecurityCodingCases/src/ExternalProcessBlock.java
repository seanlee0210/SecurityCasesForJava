import java.io.IOException;

public class ExternalProcessBlock {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        String[] cmdList = {"cmd.exe", "notemaker"};

        Process process = rt.exec(cmdList);
        try{
            int exitValue = process.exitValue();
        } catch (IllegalThreadStateException ex){
            System.out.println("Commands are not finished yet before exit.");
        }

    }
}
