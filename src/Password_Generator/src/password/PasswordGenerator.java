package password;

import java.util.Random;

public class PasswordGenerator
{
	String password;
	
	/*****************Main function*******************/
	
	public static void main(String args[])
	{
		PasswordGenerator pass = new PasswordGenerator();
		System.out.println(pass.password);
	}
	
	/******************Constructor********************/
	
	public PasswordGenerator()
	{
		password = initialize();
	}
	
	private String initialize()
	{
		String password = "";
		for(int i = 0; i<5; i++) 
		{
			int rand = ((int)(Math.random()*10000))%3;
			if(rand == 0) password += randgen((int)('9'), (int)('0')); 
			else if(rand == 1) password += randgen((int)('z'), (int)('a'));
			else password += randgen((int)('Z'), (int)('A'));
		}
		return password;
		
	}
	/*************Generating random number within a fixed range***************/
	private char randgen(int max, int min)
	{
		char c = 0;
		
		for(int i = 0; i<100; i++)
		{
			Random rn = new Random();
			Random rn2 = new Random();
			
			double tmp = rn.nextDouble()*10000;
			rn2.setSeed((int)tmp);
			
			double tmp2 = rn.nextDouble()*10000;
			
			int x = min + ((int)tmp2)%(max-min);
			
			c = (char)x;
		}
		return c;
	}
}