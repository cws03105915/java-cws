##用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况
<pre><code>
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

</pre></code>
实验结果：
不缓存运行时间： 5ms
缓存运行时间： 1ms

atx-style:
##类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。
学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中
<pre><code>
package shiyan5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;


	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;

	public class student {
		class Student {
			 
		    private long id;
		    private String name;
		    private String sex;
		    public long getId() {
		        return id;
		    }
		 
		    public void setId(long id) {
		        this.id = id;
		    }
		 
		    public String getName() {
		        return name;
		    }
		 
		    public void setName(String name) {
		        this.name = name;
		    }
		    public String getsex() {
		        return sex;
		    }
		 
		    public void setsex(String sex) {
		        this.sex = sex;
		    }
		 
		}

		
		static public ArrayList<Student> studentQueue = new ArrayList<Student>();
		

		
		public static void main(String[] args) {
			//inflattenStudent(Student.studentQueue);
			readStudent();
			SerializableStudent();
			inSerializableStudent();
			
		}
		
		
		

		private static void inSerializableStudent(){
			// TODO Auto-generated method stub
			File inFile = new File("Student.obj");
			FileInputStream finS = null;
			ObjectInputStream oin = null;

				try {
					finS = new FileInputStream(inFile);
					oin = new ObjectInputStream(finS);
					int cout = 0;
					while(true) {
						try {
							Student get = (Student)oin.readObject();
							System.out.print(++cout+":  ");
							System.out.println(get);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							break;
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}




		private static void readStudent() {
			// TODO Auto-generated method stub
				FileReader fr = null;
				BufferedReader br = null;
				try {
					fr = new FileReader("C:\\Users\\Administrator\\workspace\\shiyan5\\list.txt");
					br = new BufferedReader(fr);
					String line = "";
					String[] infos = null;
					while ((line = br.readLine()) != null) {
				//		Student temp = new Student();
						infos = line.split(" ");
			//			temp.setStudentID(infos[0]);
			//			temp.setName(infos[1]);
			//			temp.setSex(infos[2]);
			//			studentQueue.add(temp);		
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					try {
						br.close();
						fr.close();
				//		Collections.sort(studentQueue, new StudentComparator());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

		}




		private static void SerializableStudent() {
			// TODO Auto-generated method stub
			File outFile = new File("Student.obj");
			FileOutputStream foutS = null;
			ObjectOutputStream oout = null;
			try {
				foutS = new FileOutputStream(outFile);
				oout = new ObjectOutputStream(foutS);
				for(Student temp : studentQueue) {
					oout.writeObject(temp);	
					oout.flush();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	}


</pre></code>
实验结果：
123012013021 郑碧煌 女
123012015001 张永君 男
123012015003 黄树俭 男
123012015005 陈武圣 男
123012015006 林梦航 男
123012015008 朱荣盛 男
123012015012 蔡华毅 男
123012015026 唐钟玮 男
123012015030 陈祥昊 男
123012015031 李佳珍 女
123012015033 朱仲策 男
123012015036 李明 男
123012015037 詹礼浩 男
123012015040 康金发 男
123012015041 徐文坤 男
123012015054 郭子栋 男
123012015055 黄建军 男
123012015065 林华剑 男
123012015068 罗艺杰 男
123012015076 吴祖根 男
123012015094 李楠 女
123012015095 徐艺彬 男
123012015097 林贻承 男
123012015098 王鸿 女
123012015104 刘俊新 男
123012015105 刘林 男
123012015106 许建锋 男
123012015107 欧阳鑫 女
123012015109 陈浩然 男
123012015110 谢小龙 男
123012015111 林辉 男
123012015112 叶俊麟 男
123012015117 魏锡安 男
123012015119 林栋泽 男
123012015122 林拱 男
123012015123 黄宁 男
123012015125 吴腾飞 男
123012015159 林钧 男
123012015161 林威 男
123012015163 黄小刚 男