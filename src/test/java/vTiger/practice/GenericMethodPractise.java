package vTiger.practice;

public class GenericMethodPractise {

	public static void main(String[] args) {
   add(10,20);
  
	}
   public static int add(int a,int b) {
	   int c=a+b;
	   System.out.println(c);
		mul(30,30);

	return c;
	   
	}
   public static  int mul(int c,int d) {
	   int f=c*d;
	   System.out.println(f);
		sub(10,4);

	return f;
   }
private static int sub(int g,int z) {
	int x=g*z;
	System.out.println(x);
	return x;
	
}
	
	   
   }


