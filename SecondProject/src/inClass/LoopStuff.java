package inClass;

public class LoopStuff {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1;i <= 100; i++) {
			sum +=i;
		}
		System.out.println(sum);
		int sum2 = 0;
		for (int i = 1;i <= 100; i++) {
				sum2 +=i%2;
		}
		System.out.println(sum2);
		double sum3 = 0;
		for (double i = 1;i <= 100; i++) {
			sum3 += i/2;
		}
		System.out.println(sum3);
		
		int lastnum = 10;
		while(lastnum > 0){
			lastnum--;
			System.out.println(lastnum);
		}
		
		
	}

}
