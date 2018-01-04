##ChocolateBoiler.java
<pre><code>
public class ChocolateBoiler {
	private static ChocolateBoiler onlyChocolateBoiler;
	private boolean empty;
	private boolean boiled;
	private ChocolateBoiler() {
		empty = true;
		boiled =false;
	}
	public static ChocolateBoiler getChocolateBoiler() {
		if(onlyChocolateBoiler == null) {
			onlyChocolateBoiler = new ChocolateBoiler();
		}
		return onlyChocolateBoiler;
	}	
	public void fill() {
		if(empty) {
			System.out.println("正在向锅炉中添加巧克力和牛奶混合物");
			
			empty = false;
		}
		else {
			System.out.println("锅炉已满，填装失败");
		}
	}	
	public void boil() {
		if(!empty && !boiled) {
			System.out.println("正在将锅炉煮沸");
			boiled = true;
		}
	}
	public void drain() {
		if(!empty && boiled) {
			System.out.println("正在排出煮沸的巧克力和牛奶混合物");
			boiled = false;
			empty = true;
		}
	}	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return empty;
	}
	
	public boolean isBoiled() {
		// TODO Auto-generated method stub
		return boiled;
	}
}

</pre></code>


atx-style:
##Main.java 
<pre><code>

public class Main {
	/**
	 * @param args
	 */	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		ChocolateBoiler a =ChocolateBoiler.getChocolateBoiler();
		System.out.println(a.isEmpty()+","+a.isBoiled());
		a.fill();
		System.out.println(a.isEmpty()+","+a.isBoiled());
		a.boil();
		System.out.println(a.isEmpty()+","+a.isBoiled());
		a.drain();
		System.out.println(a.isEmpty()+","+a.isBoiled());
	}
}

</pre></code>
实验结果：
true,false
正在向锅炉中添加巧克力和牛奶混合物
false,false
正在将锅炉煮沸
false,true
正在排出煮沸的巧克力和牛奶混合物
true,false


