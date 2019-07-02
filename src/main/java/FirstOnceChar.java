import java.util.HashMap;
import java.util.Map;

public class FirstOnceChar {
/**
 * 找出字符串中第一个只出现一次的字符：
 * 哈希法。采用两次扫描即可实现。需要提前构建一个哈希表，把字符当成key值，把出现的次数当成value值，并初始化。

                    第一次扫描，统计出现的每个字符的次数，存到哈希表中；

                    第二次扫描，从字符串第一位开始，查看对应的value是否为1，如果为1，直接返回该字符，算法结束，否则，接着扫描。

                    算法的时间复杂度为O(n).空间复杂度为O(1).这种方法属于典型的空间换时间。
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="hheelloworrld";
		char[] arr=s.toCharArray();
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<arr.length;i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
			}
			else{
				map.put(arr[i], 1);
			}
		}
		for(int i=0;i<arr.length;i++){
			if(map.get(arr[i])==1){
				System.out.println("字符串中第一个只出现一次的字符是："+arr[i]);
				return;
			}	
		}
		
	}
	
	
}
