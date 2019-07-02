import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] num={-5,-4,-4,-4,-1,2,3,4,9,9,9,10};
		//String strNum=Arrays.toString(num);
		//System.out.println(strNum);
		ThreeSum ts=new ThreeSum();
		List<List<Integer>> res=ts.threeSum(num);
		System.out.println(res.toString());

	}
	
	/**
	 * 给出一个数组，要找出三位数相加等于0的组合，但是结果中不能包含重复的组合。 
	 * 分析：
	 * 1、首先对数组进行排序。
	 * 2、从左向右遍历数组，每次都固定一个数，然后剩下的两个数从左边与从右边向中间靠拢得到。
	 */
	public List<List<Integer>> threeSum(int[] num){
		Arrays.sort(num);
		List<List<Integer>>res=new ArrayList<List<Integer>>();
		//-5 -4 -4 -4 -1 2 3 4 9 9 9 10
		for(int i=0;i<num.length-1;i++){
			int lo=i+1,hi=num.length-1,sum=0-num[i];
			while(lo<hi){
				while(lo<hi&&num[lo]==num[lo+1]){lo++;}
				while(lo<hi&&num[hi]==num[hi-1]){hi--;}
				if(num[lo]+num[hi]==sum){
					res.add(Arrays.asList(num[i],num[lo],num[hi]));
					lo++;hi--;
				}else if(num[lo]+num[hi]<sum){lo++;}
				else{hi--;}
			}	
		}
		return res;
	}
	

}
