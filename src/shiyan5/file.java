package shiyan5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class file {
	 public static void main(String[] args) throws IOException {
		 long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
	FileReader fr = new FileReader("C:\\Users\\Administrator\\workspace\\shiyan5\\fr.txt");
	//����һ��Ŀ�Ĵ洢�ļ������ڴ洢��ȡ��������
	FileWriter fw = new FileWriter("C:\\Users\\Administrator\\workspace\\shiyan5\\fw.txt");
	//Ƶ����ȡ����
	int ch = 0;
	while((ch = fr.read()) != -1)
	{
		fw.write(ch);
	}
	//�ر�����Դ
	fw.close();
	fr.close();
	 long endTime=System.currentTimeMillis(); //��ȡ����ʱ��
	 System.out.println("����������ʱ�䣺 "+(endTime-startTime)+"ms");
	 long startTime1=System.currentTimeMillis();   //��ȡ��ʼʱ��

	FileReader fr1 = null;
	FileWriter fw1 = null;
	try
	{
		//������д������
		fr1 = new FileReader("C:\\Users\\Administrator\\workspace\\shiyan5\\fr.txt");
		fw1 = new FileWriter("C:\\Users\\Administrator\\workspace\\shiyan5\\fw1.txt");
		//����һ����ʱ�������ڻ����ȡ�����ַ�
		char[] buf = new char[1024];
				
		//����һ����������¼��ȡ�����ַ���
		int len = 0;
				
		while((len = fr1.read(buf)) != -1)
		{
			fw1.write(buf, 0, len);
		}
	}
	catch(Exception e)
	{
		//����дʧ�ܣ��׳��쳣
		throw new RuntimeException("��дʧ��");
	}
	finally
	{
		//���ļ���д��ϲ��ܹر�������
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
	 long endTime1=System.currentTimeMillis(); //��ȡ����ʱ��
	 System.out.println("��������ʱ�䣺 "+(endTime1-startTime1)+"ms");
}}
