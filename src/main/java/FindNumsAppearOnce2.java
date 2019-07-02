
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindNumsAppearOnce2 {

	public static void main(String[] args) {
		int[] arr={1,3,5,1,3,7};
		int[] result = findNumsAppearOnce1(arr);
		System.out.println(Arrays.toString(result));
		
		findNumsAppearOnce2(arr);

	}
	
	/*
	 解法1：
	1、思路：
	(1)对于出现两次的元素，使用“异或”操作后结果肯定为0，那么我们就可以遍历一遍数组，对所有元素使用异或操作，那么得到的结果就是两个出现一次的元素的异或结果。
	(2)因为这两个元素不相等，所以异或的结果肯定不是0，也就是可以在异或的结果中找到1位不为0的位，例如异或结果的最后一位不为0。
	(3)这样我们就可以最后一位将原数组元素分为两组，一组该位全为1，另一组该位全为0。
	(4)再次遍历原数组，最后一位为0的一起异或，最后一位为1的一起异或，两组异或的结果分别对应着两个结果。
	2、复杂度：
	  （1）时间复杂度：第一次循环，将所有元素异或得到对应结果，时间开销为O(n)；第二次循环，找出第一次异或结果为1的位，时间开销为O(32)；第三次循环，根据为1的位将元素分为两组进行异或得到两个结果，时间复杂度为O(n)，所以总的时间复杂度为T(n) = 2*O(n)+O(32) = O(n)。
	  （2）空间复杂度：常数，因为只分配了两个空间用于结果的保存，因此空间复杂度为常数。
	  
	综述：所以，将数组中的数从头到尾依次异或，出现偶数次的数异或都为0，最终结果是两个只出现一次的数字异或的结果，
	由于这两个数字不同，异或的结果一定不为0，即其二进制表示形式中一定存在某一位为1，找到第一个为1的位，假设是第N位，那么在对应的这一位上，这两个数一个为0，一个为1，
	根据第N位是否为1，将原数组分成两个子数组，这两个子数组分中都只包含一个只出现了一次的数，其他的数都出现了两次，两个子数组中的元素分别异或，就得到了两个只出现一次的数。
	 */

	    public static int[] findNumsAppearOnce1(int[] arr) {
	        if(arr.length < 2)
	            return arr;

	        int[] result = new int[2];  //要返回的结果  
	        int res = arr[0];  //第一次对所有元素进行亦或操作结果  
	        for(int i=1; i<arr.length; i++) {
	            res ^= arr[i];
	        }
	        System.out.println(res);//第一次异或的结果
	        int bitIndex = 0;
	        for(int i=0; i<32; i++) {  //找出亦或结果为1的位。  
	            if((res>>i & 1) == 1) {
	                bitIndex = i;
	                break;
	            }
	        }
	        System.out.println(bitIndex);//找出第一个为1的位
	        for(int i=0; i<arr.length; i++) { //根据bitIndex为1，将元素分为两组  
	            if((arr[i] >> bitIndex & 1) == 1)
	                result[0] ^= arr[i];   //对应位为1，亦或得到的结果  
	            else
	                result[1] ^= arr[i];   //对应位为0，亦或得到的结果  
	        }

	        return result;
	    }
	
	    /*
	    解法2：
	    （1）思路：这个可以可以使用一个Map，Map对应的键值key就是数组中的元素，value就是这个元素出现的次数。这样我
	    通过一次遍历数组中的元素，如果元素出现在map中，则将其对应的value加1，否则将元素添加到map中，这样遍历一遍数组，我们就可以得到数组中每个元素对应出现的次数，然后再通过遍历一遍map，返回value为1对应的key就是我们需要求得元素。
	    （2）时间复杂度：因为首先需要遍历一遍数组，时间开销为O(n)，构建完map后需要遍历一遍map找到value为1的元素，而map的个数为n/2，时间开销为O(n/2)，所以总的时间开销为O(n)。
	    （3）空间复杂度：因为需要建立一个map，而且最后map的大小为n/2，所以空间复杂度为O(n)。
	    */
	        public static void findNumsAppearOnce2(int[] arr) {
	            //Map对应的键值key就是数组中的元素，value就是这个元素出现的次数
	            Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	            for (int i : arr) {
	                if (hashMap.containsKey(i)) {
	                    hashMap.put(i, hashMap.get(i) + 1); //如果存在，value值加1
	                } else {
	                    hashMap.put(i, 1); //如果不存在，存入hashMap,value值等于1
	                }
	            }

	            //遍历一遍map，返回value为1对应的key就是我们需要求得元素
	            Set<Integer> set = hashMap.keySet();
	            for (int i : set) {
	                if (hashMap.get(i) == 1) {
	                    System.out.print(i+" ");
	                }
	            }
	        }

}
