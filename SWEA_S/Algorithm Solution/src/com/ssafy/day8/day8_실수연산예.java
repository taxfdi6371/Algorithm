package com.ssafy.day8;

public class day8_실수연산예 {

	public static void Bbit_print(byte i)
	{
	    for(int j = 7; j >= 0; j--)
	    	if (((i >> j) & 1) == 1)
	    		System.out.printf("1");
	    	else
	    		System.out.printf("0");
	    System.out.println();
	}
	
	public static void Intbit_print(int i)
	{
	    for(int j = 31; j >= 0; j--) {
	    	if (((i >> j) & 1) == 1)
	    		System.out.printf("1");
	    	else
	    		System.out.printf("0");
	    }
	    System.out.println();
	}

	public static void Longbit_print(long i)
	{
	    for(int j = 63; j >= 0; j--) {
	    	if (((i >> j) & 1) == 1)
	    		System.out.printf("1");
	    	else
	    		System.out.printf("0");
	    }
	    System.out.println();
	}
	
	public static void main(String[] args) {
		
		System.out.println("<<< -5 ~ 5 8bit 정수 bit열 출력 >>>");
		for(byte i = -5; i < 6; i++)
		{
			Bbit_print(i);
			
		}
		System.out.printf("\n\n");

		
		
		System.out.println("<<< 16진수 0xf1020304의 bit 열 >>>");
		System.out.println(Integer.toBinaryString(0xf1020304));
		System.out.printf("\n\n");
		
		
		System.out.println("<<< float 형 9.1875의 bit 열 >>>");
		Intbit_print(Float.floatToRawIntBits(9.1875f));
		System.out.printf("\n\n");
		
		
		
		System.out.println("<<< 실수형 연산 예 >>>");
		double x = (1 / 10.0) * 3;
		double y = 3 / 10.0;
		
		System.out.printf("x = %f\n", x);
		System.out.printf("y = %f\n", y);
		
		if (x == y) System.out.println("x == y");
		else		System.out.println("x != y");
		
		Longbit_print(Double.doubleToRawLongBits(x));
		Longbit_print(Double.doubleToRawLongBits(y));
		
		
		
	}

}
