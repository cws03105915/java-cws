##1.判断闰年
编写Java程序，输出从公元1990年到2007年所有
闰年的年号，每输出两个年号换一行。判断年号是
否为闰年的条件是：
（1）若年号能被4整除，而不能被100整除，则是闰年；
（2）若年号能被400整除也是闰年。
<pre><code>
public class Year {
	    public static void main(String args[]) {
	        int num = 0;
	        for(int i=1990;i<=2007;i++)
	        {
	            // 可以被4整除，不被100整除    或者     可以被400整除的是闰年
	            if((i%4==0&&i%100!=0)||(i%400==0)){
	                num++;
	                if(num%2==0)
	                {
	                    System.out.println(i);
	                }
	                else{
	                    System.out.print(i+" ");
	                }
	            }
	        }
	    }
	}
</pre></code>
实验结果：
1992 1996
2000 2004





atx-style:
##2.百分制成绩转化为等级成绩
实现方法ToGradeScore，将百分制成绩转化为等级成绩。要求对一组数据，实现批量转化。
等级与百分制对照
优：[90,100]
良：[89,80]
中：[79,70]
及格：[69,60]
不及格：[0,59]
<pre><code>
import java.util.Scanner;
public class score {
	public static void main(String[] args) {
	Scanner x = new Scanner(System.in);
	System.out.println("请输入成绩");
	int a=x.nextInt(); 
	int n=a/10;                                      
	switch(n){
	case 10:                                        
	case 9:
	System.out.println("优");
	break;
	case 8:
	System.out.println("良");
	break;
	case 7:
	System.out.println("中");
	break;
	case 6:
	System.out.println("及格");
	break;
	case 5:
	case 4:
	case 3:
	case 2:
	case 1:
	case 0:
	System.out.println("不及格");                   
	break;
	default:System.out.println(" 请输入一个正确的成绩");   
	}
	}
	}
</pre></code>
实验结果：80  90 75
良  优 中


atx-style:
##3.打印图案
利用for循环编写一个程序，将如下图案分别打印输
出。 
<pre><code>
    *
  ***
 *****
*******
 *****
  ***
   *
  </pre></code>    
  <pre><code>
   public class xinghao {
	public static void main(String[] args) {

		 final int size = 4;
		                
		 for (int i = 1; i <= size; i++) {
		  for (int j = i; j < size; j++) {
		   System.out.print(" ");
		  }

		  for (int k = 1; k <= 2 * i - 1; k++) {
		   System.out.print("*");
		  }

		  System.out.println();
		 }
		                 
		 for (int i = size - 1; i >= 1; i--) {
		  for (int j = 1; j <= size - i; j++) {
		   System.out.print(" ");
		  }

		  for (int k = 2 * i - 1; k > 0; k--) {
		   System.out.print("*");
		  }

		  System.out.println();
		 }

		}
		} 		  
  </pre></code>    
  实验结果：
 <pre><code>
    *
  ***
 *****
*******
 *****
  ***
   *
  </pre></code>    


  atx-style:
##4.水仙花数
编写程序找出所有的水仙花数；水仙花数是三位数，它的各位数字的立方和等于这个三位数本身。
 <pre><code>
 
public class flower {
	  public static void main(String[] args) {
		  for(int i=100; i<1000; i++){
		  int a = i/100;
		  int b = i/10%10;
		  int c = i%10;
		  if(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)==i)
		  System.out.println(i+"是水仙花数");
		  }
		  }
		  }
  </pre></code> 
 实验结果：   
 153是水仙花数
370是水仙花数
371是水仙花数
407是水仙花数
