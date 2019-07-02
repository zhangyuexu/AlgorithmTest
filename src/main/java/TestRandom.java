import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRandom {
	public static void main(String[] args){
		TestRandom tr=new TestRandom();
		int[] arr={1,2,2,3,3,3,4,5,5,7,7,8};
		int[] arr_new=tr.delDump(arr);
		System.out.println(Arrays.toString(tr.createRandomArray(arr_new, 5)));
		List<Integer> list=new ArrayList<Integer>();
		List<Integer> list_new=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(2);
		List<Integer> listNew=tr.delDumpList(list);
		list_new=tr.createRandomList(listNew, 3);
		System.out.println(list_new.toString());
	}
	public int[] delDump(int[] arr){
		List<Integer> list=new ArrayList<Integer>();
		for(int n:arr){
			if(!list.contains(n)){
				list.add(n);
			}
		}
		Integer[] arr2=list.toArray(new Integer[list.size()]);
		int[] arr_new=new int[arr2.length];
		for(int i=0;i<arr2.length;i++){
			arr_new[i]=arr2[i];
		}
		return arr_new;
	}
	//从数组中随机抽取不重复的元素
	public int[] createRandomArray(int[] arr,int n){
		Map map=new HashMap();
		int[] arrNew=new int[n];
		if(arr.length<=n){
			return arr;
		}
		else{
			int count=0;//新数组下标计数
			while(map.size()<n){
				int random=(int)(Math.random()*arr.length);//Math.random得出来的是1以内的小数
				if(!map.containsKey(random)){
					map.put(random, "");
					System.out.println(random+"=============="+arr[random]);
					arrNew[count++]=arr[random];
				}
			}
			return arrNew;
		}
	}
	
	//list去重
	public List<Integer> delDumpList(List<Integer> list){
		List<Integer> listNew=new ArrayList<Integer>();
		for(Integer n:list){
			if(!listNew.contains(n)){
				listNew.add(n);
			}
		}
		return listNew;
	}
	//从list中随机抽取不重复的元素
	public List createRandomList(List list,int n){
		Map map=new HashMap();
		List listNew=new ArrayList();
		if(list.size()<=n){
			return list;
		}else{
			while(map.size()<n){
				int random=(int)(Math.random()*list.size());
				if(!map.containsKey(random)){
					map.put(random, "");
					System.out.println(random+"========="+list.get(random));
					listNew.add(list.get(random));
				}
			}
			return listNew;
		}
	}

}
