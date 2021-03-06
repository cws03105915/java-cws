##FCFS算法按照任务到达的顺序进行服务，先来先服务每个Task对象可以描述为至少包含下列属性：taskID //任务IDarrivalTime //到达时间serviceTime //服务时间startingTime //开始时间
finishingTime //完成时间=开始时间+服务时间turnAroundTime //周转时间=完成时间-达到时间
weightTurnAround //带权周转时间=周转时间/服务时间其他的属性根据程序需要设置<pre><code>
package shiyan4;
import java.io.BufferedInputStream; import java.io.FileInputStream; 
import java.io.FileNotFoundException; import java.text.DecimalFormat;
import java.util.Scanner;   
public class A_FJFS_SJF {    
	public static int MaxNum = 100;   
	public static int realNum;
	public static int NowTime; 
	public static int ArrivalTime[] = new int[MaxNum];  
	public static int ServiceTime[] = new int[MaxNum];    
	public static int ServiceTime_SJF[] = new int[MaxNum];  
	public static int FinishTime[] = new int[MaxNum]; 
	public static int WholeTime[] = new int[MaxNum];  
	public static double WeightWholeTime[] = new double[MaxNum]; 
	public static double AverageWT_FCFS, AverageWT_SJF; 
	public static double AverageWWT_FCFS, AverageWWT_SJF;  
	public static int SumWT_FCFS = 0;  
	public static double SumWWT_FCFS = 0;  
	public static int SumWT_SJF = 0;
	public static double SumWWT_SJF = 0; 
	public static Scanner stdin;  
	public static void main(String[] args)
			throws FileNotFoundException { 
		
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(     "./file/01"));  
		System.setIn(in);  
		stdin = new Scanner(System.in); 
		int choice = stdin.nextInt(); 
		realNum = stdin.nextInt(); 
		for (int i = 0; i < realNum; i++) { 
			ArrivalTime[i] = stdin.nextInt();    }    
		for (int j = 0; j < realNum; j++) {
			ServiceTime[j] = stdin.nextInt();  
			ServiceTime_SJF[j] = ServiceTime[j];    
		}
		stdin.close(); 
   
	}
}
</pre></code>


atx-style:
##任务(Task)的ID、开始时间和服务时间由文件读入，形如右图所示。这个任务列表文件首先由程序生成，每秒一个任务达到，
服务时间由{6,2,1,3,9}这个集合中的数据随机获取。文件列表要包含至少100个任务。
先要求实现如下要求的FCFS当只有一个处理队列时的情况当有两个处理队列时的情况 
<pre><code>

package shiyan4;

import java.util.Scanner;

public class FCFS {
	public static int MaxNum = 100;   
	public static int realNum;
	public static int NowTime; 
	public static int ArrivalTime[] = new int[MaxNum];  
	public static int ServiceTime[] = new int[MaxNum];    
	public static int ServiceTime_SJF[] = new int[MaxNum];  
	public static int FinishTime[] = new int[MaxNum]; 
	public static int WholeTime[] = new int[MaxNum];  
	public static double WeightWholeTime[] = new double[MaxNum]; 
	public static double AverageWT_FCFS, AverageWT_SJF; 
	public static double AverageWWT_FCFS, AverageWWT_SJF;  
	public static int SumWT_FCFS = 0;  
	public static double SumWWT_FCFS = 0;  
	public static int SumWT_SJF = 0;
	public static double SumWWT_SJF = 0; 
	public static Scanner stdin;  
 //先来先服务FCFS进程调度算法 
	public static void main(String[] args) {     // 到达时间的冒泡排序，完成时间随之变动（使先到者排在前面，后到者排在后面）    
		//sort();     // 计算每个进程的完成时间、周转时间、带权周转时间、所有进程的平均周转时间以及带权平均周转时间 
		FinishTime[0] = ArrivalTime[0] + ServiceTime[0];  
		WholeTime[0] = ServiceTime[0];   
		WeightWholeTime[0] = (double) WholeTime[0] / ServiceTime[0];  
		AverageWT_FCFS = AverageWWT_FCFS = 0;  
		AverageWT_FCFS = AverageWT_FCFS + WholeTime[0];   
		AverageWWT_FCFS = AverageWWT_FCFS + WeightWholeTime[0];   
		for (int j = 1; j < realNum; j++) {   
			if (ArrivalTime[j] > FinishTime[j-1]) { 
				FinishTime[j] = ArrivalTime[j] + ServiceTime[j];   
				
				WholeTime[j] = ServiceTime[j];    } else { 
					FinishTime[j] = FinishTime[j-1] + ServiceTime[j];     
					WholeTime[j] = FinishTime[j-1] - ArrivalTime[j] + ServiceTime[j];    }   
			WeightWholeTime[j] = (double)WholeTime[j] / ServiceTime[j];       }  
		for (int i = 0; i < realNum; i++) {  
			SumWT_FCFS = SumWT_FCFS + WholeTime[i];     
			SumWWT_FCFS = SumWWT_FCFS + WeightWholeTime[i];   } 
		AverageWT_FCFS = (double)SumWT_FCFS / realNum; 
		AverageWWT_FCFS = (double)SumWWT_FCFS / realNum; 
			
	//outPUT(1);}
	}
     
}
</pre></code>

atx-style:
##SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占。按照FCFS算法的要求实现SJF算法，
同样要求处理两种情况：当只有一个处理队列时的情况当有两个处理队列时的情况<pre><code>

package shiyan4;
import java.util.Scanner;

public class SJF {
	public static int MaxNum = 100;   
	public static int realNum;
	public static int NowTime; 
	public static int ArrivalTime[] = new int[MaxNum];  
	public static int ServiceTime[] = new int[MaxNum];    
	public static int ServiceTime_SJF[] = new int[MaxNum];  
	public static int FinishTime[] = new int[MaxNum]; 
	public static int WholeTime[] = new int[MaxNum];  
	public static double WeightWholeTime[] = new double[MaxNum]; 
	public static double AverageWT_FCFS, AverageWT_SJF; 
	public static double AverageWWT_FCFS, AverageWWT_SJF;  
	public static int SumWT_FCFS = 0;  
	public static double SumWWT_FCFS = 0;  
	public static int SumWT_SJF = 0;
	public static double SumWWT_SJF = 0; 
	public static Scanner stdin;   
	sort();       int min = 0;    NowTime = ArrivalTime[0] + ServiceTime[0];// 
	FinishTime[0] = ServiceTime[0];
	ServiceTime_SJF[0]=1000;
	int allin = 0, j, k;  
	for (int i = 1; i < realNum; i++)
		{     k = 1;    min = 0;     if (allin == 0)
			{      for (j = 0; ArrivalTime[j] <= NowTime && j < realNum  j++) 
			{      if (j >= realNum)
			{       allin = 1;      }   
			}      }
		else {      j = realNum;    }   
		j = j - 1; 
		while (k <= j)
			{      if(ServiceTime_SJF[k]==0)    
				k++;     else    
				{       if(ServiceTime_SJF[min]>ServiceTime_SJF[k])
					
				}min=k;      k++; 
}       }     ServiceTime_SJF[min] = 0;
NowTime += ServiceTime[min];
FinishTime[min] = NowTime; }      
for (int i = 0; i < realNum; i++)
	{     WholeTime[i] = FinishTime[i] - ArrivalTime[i];  
	WeightWholeTime[i] = (double)WholeTime[i] / ServiceTime[i]; 
	SumWT_SJF += WholeTime[i];     SumWWT_SJF += WeightWholeTime[i]; 
	}   
AverageWT_SJF = (double)SumWT_SJF / realNum;
AverageWWT_SJF = (double)SumWWT_SJF / realNum;   
outPUT(2);  }
public static void sort() 
{   int temp1 = 0;   
int temp2 = 0;  
for (int i = 0; i < realNum - 1; i++)
{    for (int j = 0; j < realNum - 1; j++) 
{      if (ArrivalTime[j] > ArrivalTime[j + 1])
{      temp1 = ArrivalTime[j]; 
temp2 = ServiceTime[j];   
ArrivalTime[j] = ArrivalTime[j + 1];   
ServiceTime[j] = ServiceTime[j + 1]; 
ArrivalTime[j + 1] = temp1;    
ServiceTime[j + 1] = temp2;  
}  
} 
}  


public static void outPUT(int a) 
{   int k;    DecimalFormat format = new DecimalFormat("#.00");  
System.out.print("到达时间        :");   for (k = 0; k < realNum; k++)
{     System.out.print(ArrivalTime[k] + "  ");   }   
System.out.println(""); 
System.out.print("服务时间        :"); 
for (k = 0; k < realNum; k++)
{     System.out.print(ServiceTime[k] + "  ");   }  
System.out.println("");   
System.out.print("完成时间        :");  
for (k = 0; k < realNum; k++)
{     System.out.print(FinishTime[k] + "  ");  
}   
System.out.println(""); 
System.out.print("周转时间        :");  
for (k = 0; k < realNum; k++) {     System.out.print(WholeTime[k] + "  ");   } 
System.out.println("");   
System.out.print("带权周转时间:");  
for (k = 0; k < realNum; k++) 
{     System.out.print(format.format(WeightWholeTime[k]) + "  ");   }  
System.out.println("");   
if(a==1){     System.out.println("平均周转时间        :" + format.format(AverageWT_FCFS));   
System.out.println("平均带权周转时间:" + format.format(AverageWWT_FCFS));   }
else{     System.out.println("平均周转时间        :" + format.format(AverageWT_SJF));
System.out.println("平均带权周转时间:" + format.format(AverageWWT_SJF));   }  
  
System.out.println("时刻" + ArrivalTime[0] + ":" + 1 + "开始运行"); 
 for (int i = 1; i < realNum; i++) 
 {     System.out.println("时刻" + FinishTime[i - 1] + ":" + (i + 1)      + "开始运行");   }   }   }
}

</pre></code>



