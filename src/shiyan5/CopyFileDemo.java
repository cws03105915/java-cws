package shiyan5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\workspace\\shiyan5\\src\\sre.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\workspace\\shiyan5\\src\\dest.txt");
        int by = 0;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }
       
        fos.close();
        fis.close();
        FileInputStream fiss = new FileInputStream("C:\\Users\\Administrator\\workspace\\shiyan5\\src\\dest.txt");
        while ((by = fiss.read()) != -1) {
            System.out.print((char)by);
        }
        fiss.close();
    }
}
