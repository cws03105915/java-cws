##1.�ж�����
��дJava��������ӹ�Ԫ1990�굽2007������
�������ţ�ÿ���������Ż�һ�С��ж������
��Ϊ����������ǣ�
��1��������ܱ�4�����������ܱ�100�������������ꣻ
��2��������ܱ�400����Ҳ�����ꡣ
<pre><code>
public class Year {
	    public static void main(String args[]) {
	        int num = 0;
	        for(int i=1990;i<=2007;i++)
	        {
	            // ���Ա�4����������100����    ����     ���Ա�400������������
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
ʵ������
1992 1996
2000 2004





atx-style:
##2.�ٷ��Ƴɼ�ת��Ϊ�ȼ��ɼ�
ʵ�ַ���ToGradeScore�����ٷ��Ƴɼ�ת��Ϊ�ȼ��ɼ���Ҫ���һ�����ݣ�ʵ������ת����
�ȼ���ٷ��ƶ���
�ţ�[90,100]
����[89,80]
�У�[79,70]
����[69,60]
������[0,59]
<pre><code>
import java.util.Scanner;
public class score {
	public static void main(String[] args) {
	Scanner x = new Scanner(System.in);
	System.out.println("������ɼ�");
	int a=x.nextInt(); 
	int n=a/10;                                      
	switch(n){
	case 10:                                        
	case 9:
	System.out.println("��");
	break;
	case 8:
	System.out.println("��");
	break;
	case 7:
	System.out.println("��");
	break;
	case 6:
	System.out.println("����");
	break;
	case 5:
	case 4:
	case 3:
	case 2:
	case 1:
	case 0:
	System.out.println("������");                   
	break;
	default:System.out.println(" ������һ����ȷ�ĳɼ�");   
	}
	}
	}
</pre></code>
ʵ������80  90 75
��  �� ��


atx-style:
##3.��ӡͼ��
����forѭ����дһ�����򣬽�����ͼ���ֱ��ӡ��
���� 
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
  ʵ������
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
##4.ˮ�ɻ���
��д�����ҳ����е�ˮ�ɻ�����ˮ�ɻ�������λ�������ĸ�λ���ֵ������͵��������λ������
 <pre><code>
 
public class flower {
	  public static void main(String[] args) {
		  for(int i=100; i<1000; i++){
		  int a = i/100;
		  int b = i/10%10;
		  int c = i%10;
		  if(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)==i)
		  System.out.println(i+"��ˮ�ɻ���");
		  }
		  }
		  }
  </pre></code> 
 ʵ������   
 153��ˮ�ɻ���
370��ˮ�ɻ���
371��ˮ�ɻ���
407��ˮ�ɻ���
