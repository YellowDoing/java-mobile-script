import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalUtil {
  
    public static void exec(String command){
        try{
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while((read = reader.read(buffer)) > 0){
                output.append(buffer, 0, read);
            }
            reader.close();
            process.waitFor();
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}