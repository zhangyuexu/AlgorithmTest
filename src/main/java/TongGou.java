import java.util.HashMap;
import java.util.Map;

public class TongGou {
	public static void main(String[] args){
		
		System.out.println(solution("abce", "cdfg"));
		System.out.println(solution("abcd", "efgh"));
		System.out.println(solution("abcd", "ecbf"));
		System.out.println(solution("abcda", "ecbfe"));
	}
	public static boolean solution(String str1,String str2){
		Map<Character,Character> map1=new HashMap<Character, Character>();
		Map<Character,Character> map2=new HashMap<Character, Character>();
		int len1=str1.length();
		int len2=str2.length();
		if (len1 != len2){
			return false;
		}
		else{
			for(int i=0;i<len1;i++){
				if(!map1.containsKey(str1.charAt(i))){
					map1.put(str1.charAt(i), str2.charAt(i));
				}
				else{
					if(map1.get(str1.charAt(i))!=str2.charAt(i)){
						return false;
					}
				}
			}
			
			for(int i=0;i<len2;i++){
				if(!map2.containsKey(str2.charAt(i))){
					map2.put(str2.charAt(i), str1.charAt(i));
				}
				else{
					if(map2.get(str2.charAt(i))!=str1.charAt(i)){
						return false;
					}
				}
			}
			
			for(Character key1:map1.keySet()){
				for(Character key2:map2.keySet()){
					if(key1==key2){
						if(map1.get(key1)==map2.get(key2)){
							return true;
						}
						else{return false;}
					}
				}
			}
		}
		return true;
	}

}
