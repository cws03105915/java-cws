##从键盘接收字节流写入到当前目录下的src.txt文件中<pre><code>
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
</pre></code>


atx-style:
##将src.txt文件内容复制到当前目录下dest.txt文件中将dest.txt文件内容显示到屏幕上<pre><code>
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

</pre></code>
实验结果：
hello world


atx-style:
##获取某个目录下的目录信息，目录从控制台输入。目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。
对于每个文件显示其名称，修改日期和大小。目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，
并且他们各自按照文件名字符串的顺序排序。
<pre><code>
package shiyan5;
	import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;  
 
	public class FileDemo3 {
		
	    private static void test(String fileDir)throws IOException  {  
	    	FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\workspace\\shiyan5\\1.txt");
	        List<File> fileList = new ArrayList<File>();  
	        File file = new File(fileDir);  
	        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹  
	        if (files == null) {// 如果目录为空，直接退出  
	            return;  
	        }  
	        // 遍历，目录下的所有文件  
	        for (File f : files) {  
	            if (f.isFile()) {  
	                fileList.add(f);  
	            } else if (f.isDirectory()) {  
	                System.out.println(f.getAbsolutePath());  
	                test(f.getAbsolutePath());  
	            }  
	        }  
	        for (File f1 : fileList) {  
	            System.out.println(f1.getName());  
	            getModifiedTime_2(f1); 
		        fos.write(f1.getName().getBytes());
		      
	        }    fos.close();
	    }  
	    public static void getModifiedTime_2(File f1)throws IOException {
	    	FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\workspace\\shiyan5\\1.txt");
	        File f = new File("f1");              
	        Calendar cal = Calendar.getInstance();  
	        long time = f.lastModified();  
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
	        cal.setTimeInMillis(time);    
	        System.out.println("修改时间 " + formatter.format(cal.getTime()));    	
	        fos.write(formatter.format(cal.getTime()).getBytes());
	    }  
	    public static void main(String[] args)throws IOException  
	    {  
	        while(true)  
	        {  
	            BufferedReader  buf;  
	            String str;  
	            buf =new BufferedReader(new InputStreamReader(System.in));  
	            System.out.println("输入目录:");  
	            str=buf.readLine();  
	            System.out.println("该目录下文件："); 
	        test(str);
	        }  
	  
	    }  
   	    	 
	      
	}  


</pre></code>
实验结果：
该目录下文件：
C:\Users\Administrator\workspace\shiyan5\src\shiyan5
CopyFileDemo.java
修改时间 1970-01-01 08:00:00
FileDemo3.java
修改时间 1970-01-01 08:00:00
IO.java
修改时间 1970-01-01 08:00:00
dest.txt
修改时间 1970-01-01 08:00:00
sre.txt
修改时间 1970-01-01 08:00:00

