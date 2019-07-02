package nodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

public class RandomArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr1={"zz","xx","cc","gg"};
		String[] arr2={"qq","ww","ee"};
		String[] arr3={"aa","ss","dd"};
		String[] arr={};
		List<List<String>>list=new ArrayList<List<String>>();
		List<String>list0=new ArrayList<String>();
		for(int i=0;i<3;i++)
		{
			int num1=new Random().nextInt(arr1.length);
			int num2=new Random().nextInt(arr2.length);
			int num3=new Random().nextInt(arr3.length);
			list0.add(arr1[num1]);
			//arr=ArrayUtils.add(arr,arr1[num1]);
			arr1=ArrayUtils.remove(arr1,num1);
			list0.add(arr2[num2]);
			//arr=ArrayUtils.add(arr,arr2[num2]);
			arr2=ArrayUtils.remove(arr2,num2);
			list0.add(arr3[num3]);
			//arr=ArrayUtils.add(arr,arr3[num3]);
			arr3=ArrayUtils.remove(arr3,num3);
			
			list.add(list0);
			
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(list.toString());
	}

}
