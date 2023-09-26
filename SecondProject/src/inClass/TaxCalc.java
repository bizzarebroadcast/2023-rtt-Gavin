package inClass;
import java.util.Scanner;

public class TaxCalc {
	//i can either do this by in
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.print("your Marital Status. Type 1 if you are Single, Type 2 if you are"
	    		+ " Married Filing Jointly, Type 3 if you are Married Filing Separately,"
	    		+ " and Type 4 if you are a Head of Household ");
	    int index = sc.nextInt();
	    int t1=0;
	    int t2=0;
	    int t3=0;
	    int t4=0;
	    int t5=0;
	   
	    if (index == 1) {
	    	t1 = 8350;
	    	t2 = 33950;
	    	t3 = 82250;
	    	t4 = 171550;
	    	t5 = 372950;
	
	    }else if (index == 2) {
	    	t1 = 16700;
	    	t2 = 67900;
	    	t3 = 82250;
	    	t4 = 171550;
	    	t5 = 372950;
	
	    	
	    }else if (index == 3) {
	    	
	    }else if (index == 4) {
	    	
	    }
	}
	

}
