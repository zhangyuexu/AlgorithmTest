import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class Testddd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] targetarr={};
		for(int i=0;i<10;i++){
			targetarr=ArrayUtils.add(targetarr, i, i);
			
		}
		System.out.println(Arrays.toString(targetarr));
		targetarr=ArrayUtils.remove(targetarr, 0);
		System.out.println(Arrays.toString(targetarr));
		
	}

}
