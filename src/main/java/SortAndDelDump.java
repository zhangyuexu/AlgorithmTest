import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortAndDelDump {
	public static void main(String[] args){
		int[] arr={1,2,4,2,4,5,7,10,5,5,7,8,9,0,3};	
		List<Integer>list=new ArrayList<Integer>();
		for(int i:arr){
			//这里是去重
			if(!list.contains(i)){
				list.add(i);
			}
		}
		System.out.println();
		Integer[] newArr=list.toArray(new Integer[list.size()]);//list转数组，返回的是一个个对象
		System.out.println("去重后的数组是："+Arrays.toString(newArr));
		Arrays.sort(newArr);
		System.out.println("排序后的数组是："+Arrays.toString(newArr));
		
		
		/**
		for(Integer elment:newArr){
			System.out.print((int)elment+" ");
		}
		
		System.out.println();
//静态static方法中不能调用非静态non-static方法，准确地说是不能直接调用non-static方法。但是可以通过将一个对象的引用传入static方法中，再去调用该对象的non-static方法
		array2List();
		*/
	}
	public static void array2List(){
		//数组转list
		Integer[] arr={1,2,4,2,4,5,7,10,5,5,7,8,9,0,3};
		List<Integer> list=new ArrayList<Integer>(Arrays.asList(arr));
//		List<Integer>list=Arrays.asList(arr);
		for(Integer elment:list){
			System.out.print(elment+" ");
		}
	}
}
