package shiyan5;

import java.io.FileOutputStream;
import java.io.IOException;

public class IO {
	    public static void main(String[] args) throws IOException {
	        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\workspace\\shiyan5\\src\\sre.txt");
	        fos.write("hello world".getBytes());
	        fos.close();
	    }
	}


