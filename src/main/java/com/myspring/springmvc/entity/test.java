package com.myspring.springmvc.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class test {

	public static void main(String[] args) 
	{
		new test().hasmapOpr();
	}
	
	public void hasmapOpr()
	{
		HashMap<String, String> hm1 = new HashMap<String, String>();
		hm1.put("Name5", "Viji");
		hm1.put("Name2", "Arun");
		hm1.put("Name3", "Varsha");
		hm1.put("Name1", "Nithisha");
		hm1.put("Name4", "Zebra");
		System.out.println("Tm by key"+ hm1);
		TreeMap<String, String> tm = new TreeMap<String, String>(hm1);
		System.out.println("Tm by key"+ tm);
	}
	public void arraySum()
	{
		//int numbers[]= {2,4,5,6,3};
				int numbers[]= {-1,2,3,4,5,6,7,8,9,10};
				//int numbers[]= {9,7,0,2};
				int targetSum = 9;
				for (int i = 0; i < numbers.length; i++) {
					for(int j=i+1;j<numbers.length; j++)
					{
						 if(numbers[i]+ numbers[j] == targetSum)
						 {
							 System.out.println(i +"," + j);
							 break;
						 }
					}
					
				}

				
				HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
				for (int i = 0; i < numbers.length; i++) {
				
					hm.put( numbers[i],i);

				}
				System.out.println(hm.toString());
				for (int i = 0; i < numbers.length; i++) {
					//System.out.println(targetSum-numbers[i]);
					if(hm.get(targetSum-numbers[i])!= null && hm.get(targetSum-numbers[i])!= i && i>hm.get(targetSum-numbers[i]))
					{
						 System.out.println(targetSum-numbers[i] +"," + numbers[i]);
						 System.out.println("Index" + hm.get(targetSum-numbers[i]) +"," + i);
					}

				}
	}
}
