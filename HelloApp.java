import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = {1,2,3,4}; 
		/*int sum = 1;
		for  (int i=0, j=5;i<100; i++,j++,sum+=i+j);
		System.out.println(sum);*/
		
		//System.out.println(simpleNumbers(50));
		//System.out.println(cubes());
		//System.out.println(Fibonacci(14));
		
		AtomicInteger  cnt = new AtomicInteger(0);
		long start = System.nanoTime();
		System.out.println(simpleFibonacci(45,cnt));
		System.out.println(System.nanoTime()-start);
		System.out.println(cnt);
		
		cnt = new AtomicInteger(0);
		start = System.nanoTime();
		
		System.out.println(Fibonacci(45,cnt));
		System.out.println(System.nanoTime()-start);
		System.out.println(cnt);

	}
	public static List<Integer> simpleNumbers(int number){
		List<Integer> result = new ArrayList<>();
		for(int i=1; i<=number; i++) {
			boolean simple = true;
			for(int j=2; j<number; j++) {
				if(i%j==0 && i!=j ) {simple = false;}
			}
			if (simple) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	
	public static List<String> cubes(){
		List<String> result = new ArrayList<>();
		for(int i=1; i<=6; i++){
            for(int j=1; j<=6; j++){
                for(int k=1; k<=6; k++){
                    for(int m=1; m<=6; m++){
                    	result.add(Integer.toString(i)+Integer.toString(j)+Integer.toString(k)+Integer.toString(m));
            
                    }
                }
            }
         }
		return result;
	}
	
	public static int Fibonacci(int n, AtomicInteger cnt) {
		cnt.incrementAndGet();
		if (n==1 || n==2 ) return  1;
		return Fibonacci(n-1,cnt)+Fibonacci(n-2,cnt);
		
	}
	
	public static int simpleFibonacci(int n, AtomicInteger cnt) {
		int par1 = 1, par2 = 1, par3 = 2;
		for(int i=4;i<=n;i++) {
		par1 = par2;
		par2 = par3;
		par3 = par1 + par2;
		cnt.incrementAndGet();
		}
		
		
		return par3;
		
	}
	

}