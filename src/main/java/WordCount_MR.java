import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class WordCount_MR {
	public static void main(String [] args){
		String [] stl={"hello world","hello everyone","say hello to everyone in the world"};
		Hashtable<String, Integer>ht=new Hashtable<String, Integer>();
		for(int i=0;i<3;i++){
			StringTokenizer token=new StringTokenizer(stl[i]);
			while(token.hasMoreTokens()){
				String word=token.nextToken();
				if(!ht.containsKey(word)){
					ht.put(word, 1);
				}
				else{
					ht.put(word, ht.get(word)+1);
				}
			}
		}
		
		for(Iterator it=ht.keySet().iterator();it.hasNext(); ){
			String key=(String) it.next();
			int value=ht.get(key);
			System.out.print(key+":"+value+"; ");
		}
		System.out.println();
		for(Iterator<Entry<String, Integer>>it=ht.entrySet().iterator();it.hasNext(); ){
			Entry<String, Integer> entry=it.next();
			System.out.print(entry.getKey()+":"+entry.getValue()+"; ");
		}
		System.out.println();
		for(Entry<String, Integer>entry:ht.entrySet()){
			System.out.print(entry.getKey()+":"+entry.getValue()+"; ");
		}
		Set<Entry<String, Integer>>entry=ht.entrySet();
	}
	
}
