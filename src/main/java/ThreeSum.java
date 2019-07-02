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
	 * ����һ�����飬Ҫ�ҳ���λ����ӵ���0����ϣ����ǽ���в��ܰ����ظ�����ϡ� 
	 * ������
	 * 1�����ȶ������������
	 * 2���������ұ������飬ÿ�ζ��̶�һ������Ȼ��ʣ�µ����������������ұ����м俿£�õ���
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
