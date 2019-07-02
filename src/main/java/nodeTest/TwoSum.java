package nodeTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,7,5,3};
//		int target=5;
		int target=10;
//		int target=4;
		System.out.println(Arrays.toString(getTwoSum2(arr, target)));

	}

	public static int[] getTwoSum(int[] arr,int target){
		int[] result=new int[2];
		int lo=0,hi=arr.length-1;
		Arrays.sort(arr);
		while(lo<hi){
//			while(lo<hi&&arr[lo]==arr[lo+1]){lo++;}
//			while(lo<hi&&arr[hi]==arr[hi-1]){hi--;}
			if(arr[lo]+arr[hi]<target){
				lo++;
			}else if (arr[lo]+arr[hi]>target) {
				hi--;
			}else{
				result[0]=arr[lo];
				result[1]=arr[hi];
				System.out.println("lo:"+lo+","+"hi:"+hi);
				lo++;
				hi--;
			}
		}
		return result;
	}
	
	public static int[] getTwoSum2(int[] arr,int target){
		int[] res=new int[2];
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		int index=0;
		for(int curr:arr){
			map.put(curr, index++);
		}
		
		//这是遍历的每一个entry
		for(Entry<Integer, Integer> entry:map.entrySet()){
			int value=entry.getKey();//从这里定位坐标
			int subValue=target-value;
			if(map.containsKey(subValue)){
				//找到了
				res[0]=entry.getValue();//定位的坐标
				res[1]=map.get(subValue);//找到的另一个坐标
				break;
			}
		}
		return res;
	}
}
