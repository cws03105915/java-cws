package shiyan5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class file {
	 public static void main(String[] args) throws IOException {
		 long startTime=System.currentTimeMillis();   //获取开始时间
	FileReader fr = new FileReader("C:\\Users\\Administrator\\workspace\\shiyan5\\fr.txt");
	//创建一个目的存储文件，用于存储读取到的数据
	FileWriter fw = new FileWriter("C:\\Users\\Administrator\\workspace\\shiyan5\\fw.txt");
	//频繁读取操作
	int ch = 0;
	while((ch = fr.read()) != -1)
	{
		fw.write(ch);
	}
	//关闭流资源
	fw.close();
	fr.close();
	 long endTime=System.currentTimeMillis(); //获取结束时间
	 System.out.println("不缓存运行时间： "+(endTime-startTime)+"ms");
	 long startTime1=System.currentTimeMillis();   //获取开始时间

	FileReader fr1 = null;
	FileWriter fw1 = null;
	try
	{
		//创建读写流对象
		fr1 = new FileReader("C:\\Users\\Administrator\\workspace\\shiyan5\\fr.txt");
		fw1 = new FileWriter("C:\\Users\\Administrator\\workspace\\shiyan5\\fw1.txt");
		//创建一个临时容器用于缓存读取到的字符
		char[] buf = new char[1024];
				
		//定义一个变量，记录读取到的字符数
		int len = 0;
				
		while((len = fr1.read(buf)) != -1)
		{
			fw1.write(buf, 0, len);
		}
	}
	catch(Exception e)
	{
		//若读写失败，抛出异常
		throw new RuntimeException("读写失败");
	}
	finally
	{
		//当文件读写完毕才能关闭流对象
		if(fw1 != null)
			try {
				fr1.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
		if(fr1 != null)
			try
			 {
				fr1.close();
			}
			 catch (IOException e) 
			{
				e.printStackTrace();
			}			
	}
	 long endTime1=System.currentTimeMillis(); //获取结束时间
	 System.out.println("缓存运行时间： "+(endTime1-startTime1)+"ms");
}}
