import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PositiveMinusSplit {

	public static void main(String[] args) {
		Integer[] arr={-1,-3,5,-2,2,-7,6,8};
		//asList方法返回的是数组的一个视图，视图意味着对这个list操作会反映在原数组上，而且这个list是定长的，不支持add,remove等操作。
//		List<Integer> list1=Arrays.asList(arr);
//		List<Integer> list2=Arrays.asList(arr);
		
		//所以重新new一个list
		List<Integer> list1=new ArrayList<Integer>(Arrays.asList(arr));//数组转列表
		List<Integer> list2=new ArrayList<Integer>(Arrays.asList(arr));
		//循环删除list中多个元素的，应该使用迭代器iterator方式,注意的是，使用iterator的remove方法
		Iterator<Integer> it1=list1.iterator();
		while(it1.hasNext()){
			Integer x=it1.next();
			if(x>0){
				it1.remove();
			}
		}
		
		Iterator<Integer> it2=list2.iterator();
		while(it2.hasNext()){
			Integer y=it2.next();
			if(y<0){
				it2.remove();
			}
		}
		list1.addAll(list2);//两个列表合并
		System.out.println(list1.toString());
		
		Integer[] newArr=list1.toArray(new Integer[list1.size()]);//列表转数组
		Arrays.sort(newArr);
		System.out.println(newArr.toString());//这是打印数组的内存地址
		String arrString=Arrays.toString(newArr);//数组转字符串
		System.out.println(arrString);
	}
}
