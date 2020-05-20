import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GitGreen {
    public static void main(String[] args) throws IOException, InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        for (int i = 0; i < 30; i++) {
            System.out.println(i);
            OutputStream fos = new FileOutputStream("hello.txt", true);
            fos.write(97);
            Runtime.getRuntime().exec("git add .").waitFor();
            Runtime.getRuntime().exec("git commit -m \""+ format.format(new Date()) +"\"").waitFor();
            Runtime.getRuntime().exec("git push origin master").waitFor();
            TimeUnit.DAYS.sleep(1);
            fos.close();
        }
    }
}
