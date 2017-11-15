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
	        File[] files = file.listFiles();// ��ȡĿ¼�µ������ļ����ļ���  
	        if (files == null) {// ���Ŀ¼Ϊ�գ�ֱ���˳�  
	            return;  
	        }  
	        // ������Ŀ¼�µ������ļ�  
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
	        System.out.println("�޸�ʱ�� " + formatter.format(cal.getTime()));    	
	        fos.write(formatter.format(cal.getTime()).getBytes());
	    }  
	    public static void main(String[] args)throws IOException  
	    {  
	        while(true)  
	        {  
	            BufferedReader  buf;  
	            String str;  
	            buf =new BufferedReader(new InputStreamReader(System.in));  
	            System.out.println("����Ŀ¼:");  
	            str=buf.readLine();  
	            System.out.println("��Ŀ¼���ļ���"); 
	        test(str);
	        }  
	  
	    }  
   	    	 
	      
	}  
